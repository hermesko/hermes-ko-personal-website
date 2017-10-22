package com.hermesko.model;

public class ContactInfo {

	private final int id;
	private final String name, city, state, phone, email, github, linkedin;
	
	public ContactInfo(final int id, 
						final String name,
						final String city,
						final String state,
						final String phone,
						final String email,
						final String github,
						final String linkedin) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.github = github;
		this.linkedin = linkedin;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getGithub() {
		return this.github;
	}
	
	public String getLinkedin() {
		return this.linkedin;
	}
}
