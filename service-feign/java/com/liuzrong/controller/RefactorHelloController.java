
package com.liuzrong.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuzrong.model.User;
import com.liuzrong.service.HelloService;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月28日
 */
@RestController
public class RefactorHelloController implements HelloService {

	@Override
	public String hello(@RequestParam("name") String name) {
		return "Hello " + name;
	}

	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		return new User(name, age);
	}

	@Override
	public String hello(@RequestBody User user) {
		return "Hello " + user.getName() + ", " + user.getAge();
	}

}
