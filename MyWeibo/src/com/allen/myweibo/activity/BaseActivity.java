package com.allen.myweibo.activity;

import com.allen.myweibo.utils.ActivityStack;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity {

	private boolean isCreate = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityStack.getInstance().addActivity(this);
		setContentView(getLayoutId());
		isCreate = true;

	}

	@Override
	protected void onResume() {
		super.onResume();
		if (isCreate) {
			isCreate = false;
			initParams();
		}
	}

	@Override
	protected void onDestroy() {
		ActivityStack.getInstance().removeActivity(this);
		super.onDestroy();
	}

	protected abstract int getLayoutId();

	protected abstract void initParams();

}
