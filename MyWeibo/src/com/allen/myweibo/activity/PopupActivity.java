package com.allen.myweibo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.allen.myweibo.R;

public class PopupActivity extends Activity implements OnClickListener {
	private ImageView mCloseIv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_popup);
		findViews();
		setListeners();

	}

	private void findViews() {
		mCloseIv = (ImageView) findViewById(R.id.popup_iv_close);
	}

	private void setListeners() {
		mCloseIv.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.popup_iv_close:
			finish();
			break;

		default:
			break;
		}
	}
}
