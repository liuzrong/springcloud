package com.liuzrong.service;

import org.springframework.stereotype.Component;

import com.liuzrong.model.User;

/**
 * what:
 *
 * @author 刘正荣 created on 2017年12月29日
 */
@Component
public class HelloServiceFailBack implements SchedualServiceHi {
	@Override
	public String sayHiFromClientOne1(String name) {
		return "error";
	}

	@Override
	public User sayHiFromClientOne2(String name, Integer age) {
		return new User("未知", 0);
	}

	@Override
	public String sayHiFromClientOne3(User user) {
		return "error";
	}

}
