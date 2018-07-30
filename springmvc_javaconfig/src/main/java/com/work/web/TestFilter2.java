package com.work.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component("TestFilter2")
public class TestFilter2 implements Filter {

	@Override
	public void destroy() {
		System.out.println("TestFilter2 Destory");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("TestFilter2 doFilter start");
		arg2.doFilter(arg0, arg1);
		System.out.println("TestFilter2 doFilter end");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("TestFilter2 init");
	}

}
