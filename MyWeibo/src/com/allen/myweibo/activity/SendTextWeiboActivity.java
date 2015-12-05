package com.allen.myweibo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.myweibo.R;
import com.allen.myweibo.utils.AccessTokenKeeper;
import com.allen.myweibo.utils.ConstantsUtil;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.StatusesAPI;

public class SendTextWeiboActivity extends Activity implements OnClickListener {
	private TextView mCancleTv;
	private Button mSendBtn;
	private EditText mContentEdt;
	private StatusesAPI mStatusesApi;
	private Oauth2AccessToken mAccessToken;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_send_text_weibo);
		findViews();
		initViews();
	}

	private void findViews() {
		mCancleTv = (TextView) findViewById(R.id.send_text_tv_cancle);
		mSendBtn = (Button) findViewById(R.id.send_weibo_btn_send);
		mContentEdt = (EditText) findViewById(R.id.send_edt_content);
	}

	private void initViews() {
		mCancleTv.setOnClickListener(this);
		mSendBtn.setOnClickListener(this);
		mAccessToken = AccessTokenKeeper.readAccessToken(this);
		mStatusesApi = new StatusesAPI(this, ConstantsUtil.APP_KEY,
				mAccessToken);
		mContentEdt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				mSendBtn.setBackgroundColor(Color.parseColor("#ea8010"));
				mSendBtn.setTextColor(Color.WHITE);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.send_text_tv_cancle:
			finish();
			break;
		case R.id.send_weibo_btn_send:
			sendWeibo();
			startActivity(new Intent(SendTextWeiboActivity.this, MainActivity.class));
			break;
		default:
			break;
		}
	}

	private void sendWeibo() {
		String content = mContentEdt.getText().toString().trim();
		mStatusesApi.update(content, null, null, new RequestListener() {

			@Override
			public void onWeiboException(WeiboException e) {
				Toast.makeText(getApplicationContext(), "" + e,
						Toast.LENGTH_LONG).show();

			}

			@Override
			public void onComplete(String arg0) {
				Toast.makeText(getApplicationContext(), "发送成功",
						Toast.LENGTH_LONG).show();

			}
		});
	}
}
