package com.start.docker.springdockerapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start/docker")
public class HelloDocker {
	
	@GetMapping
	public String hello() {
		return " Hello Docker World";
	}
}
