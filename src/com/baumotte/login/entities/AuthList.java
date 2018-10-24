package com.baumotte.login.entities;

import java.util.HashMap;

public class AuthList {
	
	public static HashMap<String, User> authList = new HashMap<>();
	
	public static void add(User user, String encrypted) {
		//ADD: check for double login
		authList.put(encrypted, user);
	}
	
	public static void remove() {
		//todo
	}
	
	public static boolean isAuthenticated(String encrypted) {
		if(authList.get(encrypted) != null)
			return true;
		else
			return false;
	}

}
