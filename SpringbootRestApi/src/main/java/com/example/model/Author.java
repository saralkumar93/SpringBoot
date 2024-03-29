package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String language;
	public Author(int id, String firstName, String lastName, String language) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
	}
	public Author() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	

}
