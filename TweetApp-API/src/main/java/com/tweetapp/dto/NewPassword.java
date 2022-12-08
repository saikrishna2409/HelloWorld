package com.tweetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPassword {
	private String newPassword;

	public NewPassword(String newPassword) {
		super();
		this.newPassword = newPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public NewPassword() {
		super();
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
