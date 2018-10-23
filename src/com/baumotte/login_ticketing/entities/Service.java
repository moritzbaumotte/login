package com.baumotte.login_ticketing.entities;

public class Service {
	
	private String URL;
	private String name;
	
	public Service(String URL, String name) {
		this.URL = URL;
		this.name = name;
	}
	
	public Service() {
		//only used for parsing
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
