package com.emre.spring.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emre.spring.rest.validation.MyStrValidAnnot;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	// pojo yada dto denir objeye
	// @XmlAccessorType ile xml taglarini @XmlElement kullanarak değiştirebiliriz
	// jaxb ile değişiyor
	@XmlElement(name = "isim")
	@NotNull(message = "isim null olamaz")
	@Size(min = 2, max = 20, message = "isim 2-20 arası olabilir")
	private String name;
	@NotEmpty(message = "soyad boş olamaz")
	private String surname;
	@NotEmpty(message = "mail boş olamaz")
	@Email
	@MyStrValidAnnot(length = 10, message = "email 10dan kücük olamaz") // bunu custom yazdık
	private String mail;

	private String username;

	private Integer age;

	public Customer() {
	}

	public Customer(String name, String surname, Integer age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public Customer(
			@NotNull(message = "isim null olamaz") @Size(min = 2, max = 20, message = "isim 2-20 arası olabilir") String name,
			@NotEmpty(message = "soyad boş olamaz") String surname,
			@NotEmpty(message = "mail boş olamaz") @Email String mail, String username, Integer age) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.username = username;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
