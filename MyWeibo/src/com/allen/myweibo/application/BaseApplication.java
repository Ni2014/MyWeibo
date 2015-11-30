package com.allen.myweibo.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public abstract class BaseApplication extends Application {
	public static final String TAG = "Application";

	public static Context applicationContext;

	// 以键值对的形式存储用户名和密码
	public SharedPreferences sharereferences;

	@Override
	public void onCreate() {
		super.onCreate();

		applicationContext = getApplicationContext();

		// 初始化键值对存储
		sharereferences = getSharedPreferences("local_kv", MODE_PRIVATE);
	}

}
