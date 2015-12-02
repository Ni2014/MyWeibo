package com.allen.myweibo.adapter;

import java.util.ArrayList;

import com.allen.myweibo.activity.MainActivity;
import com.allen.myweibo.fragment.AboutMeFragment;
import com.allen.myweibo.fragment.DiscoverFragment;
import com.allen.myweibo.fragment.HomeFragment;
import com.allen.myweibo.fragment.MessageFragment;
import com.allen.myweibo.fragment.SettingsFragment;
import com.allen.myweibo.fragment.SplashFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Fragment> mFragments;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		initFragments();
	}

	private void initFragments() {
		mFragments = new ArrayList<Fragment>();
		mFragments.add(new HomeFragment());
		mFragments.add(new MessageFragment());
		mFragments.add(new DiscoverFragment());
		mFragments.add(new AboutMeFragment());
//		mFragments.add(new SettingsFragment());
		
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		switch (position) {
		case MainActivity.TAB_HOME:
			fragment = new HomeFragment();
			break;
		case MainActivity.TAB_MESSAGE:
			fragment = new MessageFragment();
			break;
		case MainActivity.TAB_DISCOVER:
			fragment = new DiscoverFragment();
			break;
		case MainActivity.TAB_PROFILE:
			fragment = new AboutMeFragment();
			break;
//		case MainActivity.TAB_SETTING:
//			fragment = new SettingsFragment();
//			break;
		default:
			break;
		}

		return fragment;
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

}
