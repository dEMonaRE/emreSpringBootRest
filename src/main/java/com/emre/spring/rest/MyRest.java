package com.emre.spring.rest;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emre.spring.component.MyComponent;
import com.emre.spring.model.Customer;
import com.emre.spring.model.CustomerManager;

//http requesti karşılayan componenttir 
//anatosyan extends olmaz içinde barındır diger anonatationları
//restfull webservice controlleri
//@webservice ile soap verebiliriz.
//java spec -> jax-re
@RestController
public class MyRest {

	private MyComponent component;
	@Autowired
	private CustomerManager custManager;

	@PostMapping(value = "/saveUser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Customer saveUser(@RequestBody @Validated final Customer cust) {
		return new Customer(cust.getName(), cust.getSurname(), cust.getMail(), cust.getUsername(), cust.getAge());
	}

	// http://127.0.0.1:8080/getAllUsers
	@GetMapping(value = "/getAllUsers", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Collection<Customer> getAllUsers() {
		return custManager.getAllCustomers();
	}

	@GetMapping(value = "/getAllUsersWithUsername", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Map<String, Customer> getAllUsersWithUserName() {
		return custManager.getAll();
	}

	@GetMapping("/emre/hello")
	public String hello() {
		return "hello";
	}

	@PostMapping("/emre/hello")
	public String hello2() {
		return "hello2";
	}

	// hello3'ten sonra dinamik bilgi geliyor
	@GetMapping("/emre/hello3/{xyz}")
	public String hello3(@PathVariable("xyz") final String name) {
		return "hello " + name;
	}

	// hello3'ten 3 fazla ve optional data
	@GetMapping("/emre/hello4/{xyz}/{abc}/{qwe}")
	public String hello4(@PathVariable("xyz") final String name, @PathVariable("abc") final String surname,
			@PathVariable("qwe") final Integer age) {
		return "hello " + name + " " + surname + " " + age;
	}

	// query_parametres
	// http://127.0.0.1:8080/hello5?xyz=emre&abc=zorlu&qwe=20
	@GetMapping("/hello5")
	public String hello5(@RequestParam("xyz") final String name, @RequestParam("abc") final String surname,
			@RequestParam("qwe") final Integer age) {
		return "hello " + name + " " + surname + " " + age;
	}

	// query_parametres & path variable
	// http://127.0.0.1:8080/hello5/TRUMAN?&abc=zorlu&qwe=20
	@GetMapping("/hello6/{xyz}/")
	public String hello6(@PathVariable("xyz") final String name, @RequestParam("abc") final String surname,
			@RequestParam("qwe") final Integer age) {
		return "hello6 " + name + " " + surname + " " + age;
	}

	// query_parametres & path variable
	// 3lü
	@GetMapping("/hello7/{xyz}")
	public String requestHeader(@PathVariable("xyz") final String name, @RequestParam("abc") final String surname,
			@RequestHeader("qwe") final Integer age) {
		return "hello7 " + name + " " + surname + " " + age;
	}

	// query_parametres & path variable obje döner json
	// http://127.0.0.1:8080/hello8/emre?abc=zorlu
	@GetMapping(value = "/hello8/{xyz}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer objedoner(@PathVariable("xyz") final String name, @RequestParam("abc") final String surname,
			@RequestHeader("qwe") final Integer age) {
		return new Customer(name, surname, age);
	}

	// query_parametres & path variable obje döner json
	// http://127.0.0.1:8080/hello9/emre?abc=zorlu
	// header'a Accept=application/xml ekleyip Person objesine XMLelement
	// anatotation eklemek gerekiyor
	// kendi media tipinide üretebilirsin encoder'ini oluşturmak kaydıyla - genelde
	// ihtiyaç olmuyor
	@GetMapping(value = "/hello9/{xyz}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Customer objexml(@PathVariable("xyz") final String name, @RequestParam("abc") final String surname,
			@RequestHeader("qwe") final Integer age) {
		return new Customer(name, surname, age);
	}

	// obje alir input, gelen adını gösterir editler
	// @RequestBody ile çalışır sadece
	// consume ne tipte aldıgım
	// produces ne döndüdüğüm
	// yazmasam defaultu json
	// body gerekiyorsa post etmek gerekir
	// accept headeri önemli
	@PostMapping(value = "/hello10/{xyz}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Customer objexml(@RequestBody final Customer person) {
		if (person.getName() == null) {
			// handle etttiğimiz için http 200 ok döner
			throw new IllegalArgumentException("person.name null olamaz");
		}
		return new Customer("emre", person.getSurname(), person.getAge());
	}

	// neleri handle edeceksem anotatione ekle
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorDTO handleException(final IllegalArgumentException iae) {
		ErrorDTO errDto = new ErrorDTO(iae.getMessage(), 1905);
		return errDto;
	}

	// jsr - > bean validation -- objeye notnull koyduk
	@PostMapping(value = "/hello11/{xyz}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Customer hello11(@RequestBody @Validated final Customer person) {
		return new Customer("emre", person.getSurname(), person.getAge());
	}

}
