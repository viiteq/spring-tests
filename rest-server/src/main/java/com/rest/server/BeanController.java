package com.rest.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.server.entity.Counter;
import com.rest.server.service.BeanService;

@RestController
public class BeanController {

	@Autowired
	private BeanService beanService;
	
	@RequestMapping(value = "/singletonCounter", method = RequestMethod.GET)
    public @ResponseBody Counter getSingletonCounter() {
        return beanService.getSingletonCounter();
    }
	
	@RequestMapping(value = "/prototypeCounter", method = RequestMethod.GET)
    public @ResponseBody Counter getPrototypeCounter() {
        return beanService.getPrototypeCounter();
    }
}
