package com.rest.server;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/customers/{lastName}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody List<Customer> getCustomers(@PathVariable("lastName") String lastName) {
        return custRepo.findByLastName(lastName);
    }
	
	@RequestMapping(value = "/customer/{lastName}", method = RequestMethod.POST)
    public void addCustomer(@PathVariable("lastName") String lastName) {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setLastName(lastName);
        custRepo.save(customer);
    }
}
