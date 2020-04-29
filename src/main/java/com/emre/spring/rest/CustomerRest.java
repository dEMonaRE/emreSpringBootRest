package com.emre.spring.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emre.spring.model.Customer;
import com.emre.spring.model.CustomerManager;

@RestController
@RequestMapping("/person")
public class CustomerRest {

	@Autowired
	private CustomerManager cm;

	@PutMapping
	public String addCustomer(@RequestBody Customer customer) {
		this.cm.addCustomer(customer);
		return "OK";
	}

	@GetMapping("/{email}")
	public Customer getCustomer(@PathVariable("email") String email) {
		return this.cm.getCustomer(email);
	}

	@GetMapping("/all")
	public Collection<Customer> getCustomer() {
		return this.cm.getAllCustomers();
	}

}
