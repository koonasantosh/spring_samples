package com.work.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.work.web.TestFilter1;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctxt = new AnnotationConfigWebApplicationContext();
		ctxt.register(WebAppConfig.class);
		ctxt.setServletContext(servletContext);
		ctxt.refresh();
		
		DispatcherServlet ds = new DispatcherServlet(ctxt);
		
		ServletRegistration.Dynamic reg = servletContext.addServlet("ds", ds);
		reg.addMapping("/");
		reg.setLoadOnStartup(1);
		
		FilterRegistration.Dynamic tf1 = servletContext.addFilter("tf1", TestFilter1.class);
		tf1.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "*");
		
		FilterRegistration.Dynamic tf2 = servletContext.addFilter("TestFilter2", DelegatingFilterProxy.class);
		tf2.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "*");
	}
}
