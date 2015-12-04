package com.allen.myweibo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.allen.myweibo.utils.ActivityStack;

public abstract class BaseActivity extends FragmentActivity {

	private boolean isCreate = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityStack.getInstance().addActivity(this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(getLayoutId());
		findViews();
		isCreate = true;

	}

	protected void findViews() {

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
