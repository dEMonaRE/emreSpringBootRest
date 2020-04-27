package com.emre.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emre.spring.component.MyComponent;
import com.emre.spring.model.CustomerManager;

//component scan
@SpringBootApplication
public class EmreSpringBootApplication {
	// önce bu oluşturuluyor, sonra EmreSpringBootApplication oluşuyor

	// springin özel anatotion
	// controller--web
	// service-business layer
	// repository-data jpa
	// configuration--bean config

	@Autowired
	private MyComponent component;

	@Autowired
	private CustomerManager custManager;

	public static void main(String[] args) {

		SpringApplication.run(EmreSpringBootApplication.class, args);
	}

}
