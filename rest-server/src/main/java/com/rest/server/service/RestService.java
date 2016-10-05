package com.rest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rest.server.entity.User;

public class RestService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getResponse() {
		return "hello!";
	}
	
	public List<User> getUsers() {
		return jdbcTemplate.query("select * from Users", 
				(rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
	}
	
	public void addUser() {
		jdbcTemplate.execute("insert into Users values (1, 'x', 'xmail')");
	}
}
