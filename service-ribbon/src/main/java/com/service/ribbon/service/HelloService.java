/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:TODO
 * Module Name:service-ribbon
 *
 */
package com.service.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月11日
 */
@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;

	public String hiservice(String name) {
		return restTemplate.getForObject("http://SERVICE-HELLO/hi?name=" + name, String.class);
	}

}
