package com.rest.server;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.server.dao.CustomerRepository;
import com.rest.server.entity.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository custRepo;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody List<Customer> getCustomers() {
        return custRepo.findByLastName("X");
    }
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void addCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setLastName("X");
        custRepo.save(customer);
    }
}
