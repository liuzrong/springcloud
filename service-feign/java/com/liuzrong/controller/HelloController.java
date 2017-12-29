package com.liuzrong.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuzrong.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月28日
 */
@Slf4j
@RestController
public class HelloController {

	@Value("${server.port}")
	String port;

	@Autowired
	private Registration instance;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {

		return "Hello World:" + port;
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam String name) throws InterruptedException {
		// 测试超时触发断路器
		int sleepTime = new Random().nextInt(3000);
		log.info("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);

		log.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		return "Hello:" + name + ",port:" + port;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
		log.info("/hello2:" + "name:" + name + "age:" + age);
		log.info("/hello2, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		return new User(name, age);
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		log.info("/hello3, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		return "Hello " + user.getName() + ", " + user.getAge() + ",port:" + port;
	}

}
