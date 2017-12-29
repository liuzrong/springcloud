package com.liuzrong.web;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private Registration instance;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {

		// 测试超时触发断路器
		// int sleepTime = new Random().nextInt(3000);
		// logger.info("sleepTime:" + sleepTime);
		// Thread.sleep(sleepTime);

		// logger.info("/hello, host:" + instance.getHost() + ", service_id:" +
		// instance.getServiceId());
		return "Hello World";
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam String name) throws InterruptedException {
		// 测试超时触发断路器
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);
		// logger.info("/hello1, host:" + instance.getHost() + ", service_id:" +
		// instance.getServiceId());
		return "Hello " + name;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) throws InterruptedException {
		// 测试超时触发断路器
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);
		// logger.info("/hello2, host:" + instance.getHost() + ", service_id:" +
		// instance.getServiceId());
		return new User(name, age);
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user) throws InterruptedException {
		// 测试超时触发断路器
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);
		// logger.info("/hello3, host:" + instance.getHost() + ", service_id:" +
		// instance.getServiceId());
		return "Hello " + user.getName() + ", " + user.getAge();
	}

}