package com.techexposer.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.techexposer.sample.controller.interceptor.LoggingInterceptor;

/**
 * This object is used to define Spring WebMVC framework objects 
 * such as RequestMapping and RequestAdapter.
 * 
 * The @EnableWebMvc annotation loads the DelegatingWebMvcConfiguration which defines the default 
 * objects.
 * 
 * The WebMvcConfigurer interface is implemented to customize or add framework objects to DispatcherServlet
 * 
 * @author Santosh Koona
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.techexposer.sample.controller")
public class SpringWebMVCConfig implements WebMvcConfigurer {

	@Autowired
	private LoggingInterceptor loggingInterceptor;
	
	
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(loggingInterceptor);
		
	}
}
