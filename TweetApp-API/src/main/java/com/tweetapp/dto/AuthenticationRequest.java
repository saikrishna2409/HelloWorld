package com.tweetapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	public AuthenticationRequest() {
		super();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
}
