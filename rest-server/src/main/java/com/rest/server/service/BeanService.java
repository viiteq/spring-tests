package com.rest.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.rest.server.entity.Counter;

public class BeanService {

	@Autowired
	private ApplicationContext ctx;
	
	public Counter getPrototypeCounter() {
		return (Counter) ctx.getBean("prototypeCounter");
	}
	
	public Counter getSingletonCounter() {
		return (Counter) ctx.getBean("singletonCounter");
	}
}
