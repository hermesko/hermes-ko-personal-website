package com.hermesko.util;

import java.util.Base64;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EncryptedDataSource extends DriverManagerDataSource{
	
	@Override
	public String getPassword() {
		final String password = super.getPassword();
		return decode(password);
	}
	
	private String decode(String decode) {
		return new String(Base64.getDecoder().decode(decode));
	}
	
	@SuppressWarnings("unused")
	private String encode(String password) {
		return new String(Base64.getEncoder().encode(password.getBytes()));
	}
}
