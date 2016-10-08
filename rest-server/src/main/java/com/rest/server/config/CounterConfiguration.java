package com.rest.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.rest.server.entity.Counter;

@Configuration
public class CounterConfiguration {

	private int cnt = 0;
	
	@Bean("prototypeCounter")
	@Scope("prototype")
	public Counter pCounter() {
		return new Counter(cnt++);
	}
	
	@Bean(name = "singletonCounter", destroyMethod = "cleanup")
//	@Lazy
	public Counter sCounter() {
		return new Counter(cnt++);
	}
}
