package com.allen.myweibo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.allen.myweibo.R;
import com.allen.myweibo.utils.AccessTokenKeeper;
import com.allen.myweibo.utils.ConstantsUtil;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.UsersAPI;

public class WeiboTestActivity extends Activity implements OnClickListener {

	private Button mSsoBtn, mInfoBtn, mClearBtn;
	private SsoHandler mSsoHandler;
	private AuthInfo mAuthInfo;
	private Oauth2AccessToken mAccessToken;
	UsersAPI mUserApi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weibo_test);
		findViews();
		initViews();
		setListeners();
	}

	private void findViews() {
		mSsoBtn = (Button) findViewById(R.id.test_btn_sso);
		mInfoBtn = (Button) findViewById(R.id.test_btn_info);
		mClearBtn = (Button) findViewById(R.id.test_btn_clear);

	}

	private void initViews() {
		mAuthInfo = new AuthInfo(this, ConstantsUtil.APP_KEY,
				ConstantsUtil.REDIRECT_URL, ConstantsUtil.SCOPE);
		mSsoHandler = new SsoHandler(WeiboTestActivity.this, mAuthInfo);
		mAccessToken = AccessTokenKeeper.readAccessToken(this);
		mUserApi = new UsersAPI(this, ConstantsUtil.APP_KEY, mAccessToken);
	}

	private void setListeners() {
		mSsoBtn.setOnClickListener(this);
		mInfoBtn.setOnClickListener(this);
		mClearBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.test_btn_sso:
			mSsoHandler.authorizeClientSso(new AuthListener());
			break;
		case R.id.test_btn_info:
			getCounts();
			break;
		case R.id.test_btn_clear:
			AccessTokenKeeper.clear(getApplicationContext());
			break;

		default:
			break;
		}

	}

	private void getCounts() {

		// long[] uids = { Long.parseLong(mAccessToken.getUid()) };
		long uids = Long.parseLong(mAccessToken.getUid());
		RequestListener reqListener = new RequestListener() {

			@Override
			public void onWeiboException(WeiboException arg0) {
				Toast.makeText(WeiboTestActivity.this, "Error" + arg0,
						Toast.LENGTH_LONG).show();

			}

			@Override
			public void onComplete(String response) {
				Toast.makeText(WeiboTestActivity.this, response,
						Toast.LENGTH_LONG).show();
			}
		};
		mUserApi.show(uids, reqListener);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (mSsoHandler != null) {
			mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
		}
	}

	public class AuthListener implements WeiboAuthListener {

		@Override
		public void onCancel() {
			// TODO Auto-generated method stub

		}

		@Override
		public void onComplete(Bundle values) {
			mAccessToken = Oauth2AccessToken.parseAccessToken(values);
			if (mAccessToken.isSessionValid()) {

				// 保存 Token 到 SharedPreferences
				AccessTokenKeeper.writeAccessToken(WeiboTestActivity.this,
						mAccessToken);
				Toast.makeText(WeiboTestActivity.this, "授权成功",
						Toast.LENGTH_LONG).show();
			}

		}

		@Override
		public void onWeiboException(WeiboException e) {
			Toast.makeText(WeiboTestActivity.this,
					"Auth exception : " + e.getMessage(), Toast.LENGTH_LONG)
					.show();

		}

	}
}
