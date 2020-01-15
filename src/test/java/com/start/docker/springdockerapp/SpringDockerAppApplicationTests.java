package com.start.docker.springdockerapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDockerAppApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void simpleTestJenkin(){
	   int a=2;
	   int b=2;
	   assertTrue(a+b ==4);
	}

}
