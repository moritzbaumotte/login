package com.baumotte.login.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.baumotte.login.entities.TokenBuilder;
import com.baumotte.login.entities.User;

public class TokenBuilder_Test {

	@Test
	void test_getTickets() {
		TokenBuilder tb = new TokenBuilder();
		tb.generateToken(new User("info@baumotte.com", "1234"));
		assertTrue(true);
	}
	
}
