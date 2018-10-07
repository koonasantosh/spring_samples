package com.techexposer.sample.config;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.techexposer.sample.web.SampleFilter;


/**
 * This object is used to configure the Spring WebMVC platform.
 * This includes creating the DispatcherServlet and registering to ServletContainer
 * Optionally create ContextLoaderListener and register to context.
 * 
 * @author Santosh Koona
 *
 */
public class SpringWebMVCInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext springWebContext = new 
				AnnotationConfigWebApplicationContext();
		springWebContext.register(SpringWebMVCConfig.class);
		springWebContext.setServletContext(servletContext);
		springWebContext.refresh();
		
		DispatcherServlet ds = new DispatcherServlet(springWebContext);
		
		servletContext.addServlet("ds", ds).addMapping("/");		
		
		servletContext.addFilter("sf", SampleFilter.class).addMappingForUrlPatterns(
				null, false, "/");
	}
}
