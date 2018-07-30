package com.work.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends AbstractSecurityWebApplicationInitializer{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder amb) throws Exception{
		
		amb.inMemoryAuthentication().withUser("admin").password("welcome").roles("USER");
	}
}
