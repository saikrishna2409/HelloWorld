package com.tweetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TweetUpdate {
	private String tweetId;
	public TweetUpdate() {
		super();
	}
	public TweetUpdate(String tweetId, String tweetText) {
		super();
		this.tweetId = tweetId;
		this.tweetText = tweetText;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweetText() {
		return tweetText;
	}
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	private String tweetText;
}
