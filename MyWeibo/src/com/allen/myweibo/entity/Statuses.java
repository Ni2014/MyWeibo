package com.allen.myweibo.entity;

import java.util.List;

/**
 * 单条微博
 * 
 */
public class Statuses {
	private User user;
	private String createdAt;
	private String text;
	private List<String> picUrls;
	private int repostsCount;
	private int commentsCount;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Statuses(User user, String createdAt, String text,
			List<String> picUrls, int repostsCount, int commentsCount) {
		super();
		this.user = user;
		this.createdAt = createdAt;
		this.text = text;
		this.picUrls = picUrls;
		this.repostsCount = repostsCount;
		this.commentsCount = commentsCount;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(List<String> picUrls) {
		this.picUrls = picUrls;
	}

	public int getRepostsCount() {
		return repostsCount;
	}

	public void setRepostsCount(int repostsCount) {
		this.repostsCount = repostsCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

}
