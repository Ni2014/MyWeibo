package com.allen.myweibo.utils;

import java.util.Stack;

import android.app.Activity;

/**
 * Activity的堆栈管理
 * 
 * @author hadoop
 * 
 */
public class ActivityStack {
	private static ActivityStack mSingleInstance;
	private Stack<Activity> mActicityStack;

	private ActivityStack() {
		mActicityStack = new Stack<Activity>();
	}

	public static ActivityStack getInstance() {
		if (null == mSingleInstance) {
			mSingleInstance = new ActivityStack();
		}
		return mSingleInstance;
	}

	public Stack<Activity> getStack() {
		return mActicityStack;
	}

	/**
	 * 入栈
	 * 
	 */
	public void addActivity(Activity activity) {
		mActicityStack.push(activity);
	}

	/**
	 * 出栈
	 * 
	 */
	public void removeActivity(Activity activity) {
		mActicityStack.remove(activity);
	}

	/**
	 * 彻底退出
	 * 
	 */
	public void finishAllActivity() {
		Activity activity;
		while (!mActicityStack.empty()) {
			activity = mActicityStack.pop();
			if (activity != null)
				activity.finish();
		}
	}

}
