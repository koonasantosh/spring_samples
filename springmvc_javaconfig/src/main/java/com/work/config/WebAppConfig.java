package com.work.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.work.controller.interceptors.TestInterceptor1;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.work.controller", "com.work.web"})
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	private TestInterceptor1 testInterceptor1;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		InterceptorRegistration ir = registry.addInterceptor(testInterceptor1);
		ir.addPathPatterns("/*");
		ir.excludePathPatterns("/sayHai");
	}
}
