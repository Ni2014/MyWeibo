package com.allen.myweibo.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	private Context context;
	protected Dialog dialog;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(), container, false);
		initParams();

		return view;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	/**
	 * 初始化布局
	 * 
	 */
	protected abstract int getLayoutId();

	/**
	 * 参数设置
	 * 
	 */
	protected abstract void initParams();

}
