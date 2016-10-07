package com.rest.server.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rest.server.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
