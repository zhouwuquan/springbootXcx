package com.imooc.zhou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Value("${name}")
	private String name;

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		
		return name;
	}
}
