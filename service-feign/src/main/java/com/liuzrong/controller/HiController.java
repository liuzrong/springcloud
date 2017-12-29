package com.liuzrong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuzrong.model.User;
import com.liuzrong.service.SchedualServiceHi;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月11日
 */

@RestController
public class HiController {

	@Autowired
	SchedualServiceHi schedualServiceHi;

	@Autowired
	RefactorHelloService refactorHelloService;

	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String sayHi(@RequestParam("name") String name) {
		return schedualServiceHi.sayHiFromClientOne1(name);
	}

	@RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
	public String sayHi2() {
		StringBuilder sb = new StringBuilder();
		sb.append(schedualServiceHi.sayHiFromClientOne1("nihao")).append("\n");
		sb.append(schedualServiceHi.sayHiFromClientOne2("lisi", 16)).append("\n");
		sb.append(schedualServiceHi.sayHiFromClientOne3(new User("zhansan", 12))).append("\n");
		return sb.toString();
	}

	@RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
	public String helloConsumer3() {
		StringBuilder sb = new StringBuilder();
		sb.append(refactorHelloService.hello("MIMI")).append("\n");
		sb.append(refactorHelloService.hello("MIMI", 20)).append("\n");
		sb.append(refactorHelloService.hello(new User("MIMI", 20))).append("\n");
		return sb.toString();
	}

}
