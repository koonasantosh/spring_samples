package com.techexposer.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Santosh Koona
 *
 */
@Controller
public class SampleController {

	@RequestMapping(path="/sayHello", method=RequestMethod.GET)
	@ResponseBody
	public String sayHello(){
		
		return "Hello Spring WebMVC";
	}
}
