package com.liuzrong.controller;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.liuzrong.service.HelloService;

@FeignClient(value = "service-hello")
public interface RefactorHelloService extends HelloService {

}