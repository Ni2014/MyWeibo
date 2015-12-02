package com.allen.myweibo.controller;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.allen.myweibo.fragment.AboutMeFragment;
import com.allen.myweibo.fragment.DiscoverFragment;
import com.allen.myweibo.fragment.HomeFragment;
import com.allen.myweibo.fragment.MessageFragment;

/**
 * 管理Fragment
 * 
 * @author hadoop
 * 
 */
public class UIManager {
	private HomeFragment mHomeFrag;
	private MessageFragment mMsgFrag;
	private DiscoverFragment mDiscoverFrag;
	private AboutMeFragment mAboutFrag;
	private FragmentManager mFragManager;
	private FragmentActivity mActivity;

	public UIManager(FragmentActivity activity) {
		this.mActivity = activity;
		mFragManager = mActivity.getSupportFragmentManager();
	}

	public void showHomeFragment() {

	}

	public void showMessageFragment() {

	}

	public void showDiscoverFragment() {

	}

	public void showAboutMeFragment() {

	}
}
