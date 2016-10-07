package com.rest.server.service;

import java.util.List;

import com.rest.server.entity.User;

public interface RestService {

	String getResponse();

	List<User> getUsers();

	void addUser();

}