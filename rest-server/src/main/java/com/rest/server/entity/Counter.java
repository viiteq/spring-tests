package com.rest.server.entity;

import javax.annotation.PostConstruct;

public class Counter {

	private int cnt;
	
	public Counter(int cnt) {
		this.cnt = cnt;
	}

	
	public int getCnt() {
		return cnt;
	}
	
	@PostConstruct
	void init() {
		System.out.println("initializing");
	}
	
	void cleanup() {
		System.out.println("destroying");
	}
}
