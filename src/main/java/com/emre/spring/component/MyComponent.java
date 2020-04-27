package com.emre.spring.component;

import org.springframework.stereotype.Component;

//singleton-1 kez oluşturur-istediğimiz kadar newleriz.
//inject etmek lazım declare ettk
@Component
public class MyComponent {
	private String nameString;

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
}
