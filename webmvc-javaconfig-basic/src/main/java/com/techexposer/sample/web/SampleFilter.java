package com.techexposer.sample.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SampleFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("In SampleFilter; doFilter (before)");
		chain.doFilter(request, response);
		System.out.println("In SampleFilter; doFilter (after)");

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
