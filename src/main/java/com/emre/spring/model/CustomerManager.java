package com.emre.spring.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CustomerManager {

	private Map<String, Customer> customerMap = new HashMap<>();

	public void addCustomer(Customer cust) {
		customerMap.put(cust.getUsername(), cust);
	}

	public Collection<Customer> getAllCustomers() {
		if (this.customerMap == null) {
			this.customerMap = new HashMap<>();
		}
		this.customerMap.put("aemrezorlu", new Customer("Emre", "Zorlu", "ahmet@emrezorlu.com", "aemrezorlu", 30));
		this.customerMap.put("asdasd", new Customer("asdasd", "vvvv", "asd@asdddd.com", "asdasd", 22));
		this.customerMap.put("xxx", new Customer("xxx", "xxxx", "xxxxx@xxxxx.com", "xxxx", 111));
		return this.customerMap.values();
	}

	public Map<String, Customer> getAll() {
		if (this.customerMap == null) {
			this.customerMap = new HashMap<>();
		}
		this.customerMap.put("aemrezorlu", new Customer("Emre", "Zorlu", "ahmet@emrezorlu.com", "aemrezorlu", 30));
		this.customerMap.put("asdasd", new Customer("asdasd", "vvvv", "asd@asdddd.com", "asdasd", 22));
		this.customerMap.put("xxx", new Customer("xxx", "xxxx", "xxxxx@xxxxx.com", "xxxx", 111));
		return this.customerMap;
	}

	public Customer getCustomer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
