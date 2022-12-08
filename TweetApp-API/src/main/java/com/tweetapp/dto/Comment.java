package com.tweetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	private String username;
	private String comment;
	public String getUsername() {
		return username;
	}
	public Comment() {
		super();
	}
	public Comment(String username, String comment) {
		super();
		this.username = username;
		this.comment = comment;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
