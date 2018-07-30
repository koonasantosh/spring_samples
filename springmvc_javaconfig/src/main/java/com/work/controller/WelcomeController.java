package com.work.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/sayHello")
	public String sayHello(){
		
		System.out.println("in sayHello");
		return "Hello";
	}
	
	@RequestMapping("/sayHai")
	public String sayHai(){
		
		System.out.println("in sayHai");
		return "Hai";
	}
}
