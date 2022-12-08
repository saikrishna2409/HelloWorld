package com.tweetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Like {

	private String tweetId;
	private String username;
	public String getTweetId() {
		return tweetId;
	}
	public Like() {
		super();
	}
	public Like(String tweetId, String username) {
		super();
		this.tweetId = tweetId;
		this.username = username;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
