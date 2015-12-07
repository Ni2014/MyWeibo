package com.allen.myweibo.entity;

import java.util.List;

/**
 * 获取到的微博数组 
 *
 */
public class WeiboInfo {
	
	private List<Statuses> statuses;

	public WeiboInfo(List<Statuses> statuses) {
		super();
		this.statuses = statuses;
	}

	public List<Statuses> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Statuses> statuses) {
		this.statuses = statuses;
	}
	
}
