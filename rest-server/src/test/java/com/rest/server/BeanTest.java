package com.rest.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("rest-app-context.xml");
		
		
		
		ctx.close();
	}
}
