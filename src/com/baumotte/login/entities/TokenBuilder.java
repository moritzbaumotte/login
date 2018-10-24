package com.baumotte.login.entities;

public class TokenBuilder {

	private final String SEED = "7";
	
	public String generateToken(User user) {
		String tokenString = user.getEmail() + user.getPassword();
		int intArray = Integer.parseInt(tokenString.trim());
		System.out.println(intArray);
		return null;
	}

}
