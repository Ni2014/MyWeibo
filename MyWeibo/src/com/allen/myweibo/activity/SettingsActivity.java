package com.allen.myweibo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.allen.myweibo.R;

public class SettingsActivity extends Activity implements OnClickListener {

	private ImageView mSettingsIv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_settings);
		findViews();
		setListeners();
	}

	private void findViews() {
		mSettingsIv = (ImageView) findViewById(R.id.settings_iv_set);

	}

	private void setListeners() {
		mSettingsIv.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.settings_iv_set:
			finish();
			break;

		default:
			break;
		}

	}
}
