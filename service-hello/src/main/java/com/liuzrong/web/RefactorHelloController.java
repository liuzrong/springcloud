package com.liuzrong.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuzrong.model.User;
import com.liuzrong.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RefactorHelloController implements HelloService {

	@Value("${server.port}")
	int port;

	@Override
	public String hello(@RequestParam("name") String name) {
		log.info("hello4:" + name + ",port:" + port);
		return "Hello " + name;
	}

	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		log.info("hello5:" + name + "," + age + ",port:" + port);
		return new User(name, age);
	}

	@Override
	public String hello(@RequestBody User user) {
		log.info("hello6:" + user.getName() + "," + user.getAge());
		return user.getName() + "," + user.getAge();
	}

}