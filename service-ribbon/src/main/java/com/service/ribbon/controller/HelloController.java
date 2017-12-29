/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:TODO
 * Module Name:service-ribbon
 *
 */
package com.service.ribbon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ribbon.service.HelloService;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月11日
 */
@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/hi")
	public String hi(String name, HttpServletRequest request) {
		return helloService.hiservice(name);
	}

}
