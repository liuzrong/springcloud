/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:TODO
 * Module Name:service-feign
 *
 */
package com.liuzrong.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liuzrong.model.User;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月11日
 */
@FeignClient(value = "service-hello", fallback = HelloServiceFailBack.class)
public interface SchedualServiceHi {

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	String sayHiFromClientOne1(@RequestParam("name") String name);

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	User sayHiFromClientOne2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@RequestMapping(value = "/hello3", method = RequestMethod.GET)
	String sayHiFromClientOne3(@RequestBody User user);

}
