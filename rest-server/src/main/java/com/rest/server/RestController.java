package com.rest.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.server.entity.User;
import com.rest.server.service.RestService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	@Qualifier("helloRest")
	private RestService service;

	@RequestMapping("/helloWorld")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<String>(service.getResponse(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody List<User> getUsers() {
        return service.getUsers();
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser() {
        service.addUser();
    }
	
	
	
}
