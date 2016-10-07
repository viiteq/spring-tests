package com.rest.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rest.server.entity.Customer;

public class BeanTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("rest-app-context.xml");
		
		System.out.println(ctx.getBean(Customer.class));
		
		ctx.close();
	}
}
