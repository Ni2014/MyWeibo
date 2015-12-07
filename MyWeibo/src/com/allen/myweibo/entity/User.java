package com.allen.myweibo.entity;

/**
 * 单条微博的user对象
 * 
 */
public class User {
	private String name;
	// 头像缩略图
	private String profileImageUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public User(String name, String profileImageUrl) {
		super();
		this.name = name;
		this.profileImageUrl = profileImageUrl;
	}

}
