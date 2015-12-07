package com.allen.myweibo.activity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.sina.weibo.sdk.openapi.StatusesAPI;
import com.sina.weibo.sdk.openapi.UsersAPI;

public class WeiboTestActivity extends Activity implements OnClickListener {

	private Button mSsoBtn, mInfoBtn, mClearBtn, mTextWeiboBtn, mMixWeiboBtn,
			mGetWeiboInfoBtn;
	private SsoHandler mSsoHandler;
	private AuthInfo mAuthInfo;
	private Oauth2AccessToken mAccessToken;
	private UsersAPI mUserApi;
	private StatusesAPI mStatusApi;
	private Drawable mDrawable;
	private EditText mWeiboInfoEdt;
	private ImageView mIconIv;
	private String mIconUrl;

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
		mTextWeiboBtn = (Button) findViewById(R.id.test_btn_text_weibo);
		mMixWeiboBtn = (Button) findViewById(R.id.test_btn_img_text_weibo);
		mGetWeiboInfoBtn = (Button) findViewById(R.id.test_btn_getinfo__weibo);
		mWeiboInfoEdt = (EditText) findViewById(R.id.test_edt_info);
		mIconIv = (ImageView) findViewById(R.id.test_iv_icon);

	}

	private void initViews() {
		mAuthInfo = new AuthInfo(this, ConstantsUtil.APP_KEY,
				ConstantsUtil.REDIRECT_URL, ConstantsUtil.SCOPE);
		mSsoHandler = new SsoHandler(WeiboTestActivity.this, mAuthInfo);
		mAccessToken = AccessTokenKeeper.readAccessToken(this);
		mUserApi = new UsersAPI(this, ConstantsUtil.APP_KEY, mAccessToken);
		mStatusApi = new StatusesAPI(this, ConstantsUtil.APP_KEY, mAccessToken);
		mDrawable = getResources().getDrawable(R.drawable.discover_pic);

	}

	private void setListeners() {
		mSsoBtn.setOnClickListener(this);
		mInfoBtn.setOnClickListener(this);
		mClearBtn.setOnClickListener(this);
		mTextWeiboBtn.setOnClickListener(this);
		mMixWeiboBtn.setOnClickListener(this);
		mGetWeiboInfoBtn.setOnClickListener(this);
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
		case R.id.test_btn_text_weibo:
			mStatusApi.update("发送一条纯文字的微博", null, null, new RequestListener() {

				@Override
				public void onWeiboException(WeiboException arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onComplete(String arg0) {
					Toast.makeText(getApplicationContext(), "发送成功",
							Toast.LENGTH_LONG).show();

				}
			});
			break;
		case R.id.test_btn_img_text_weibo:
			Bitmap bitmap = ((BitmapDrawable) mDrawable).getBitmap();
			mStatusApi.upload("测试图文微博", bitmap, null, null,
					new RequestListener() {

						@Override
						public void onWeiboException(WeiboException arg0) {
							Toast.makeText(getApplicationContext(),
									"Error" + arg0, Toast.LENGTH_LONG).show();
						}

						@Override
						public void onComplete(String arg0) {
							Toast.makeText(getApplicationContext(), "发送图文微博成功",
									Toast.LENGTH_LONG).show();
						}
					});
			break;

		case R.id.test_btn_getinfo__weibo:
			mStatusApi.friendsTimeline(0L, 0L, 1, 3, false, 0, false,
					new RequestListener() {

						@Override
						public void onWeiboException(WeiboException exception) {
							Toast.makeText(WeiboTestActivity.this,
									"Error" + exception, Toast.LENGTH_LONG)
									.show();

							mWeiboInfoEdt.setText(exception + "");

						}

						@Override
						public void onComplete(String response) {

							Toast.makeText(WeiboTestActivity.this, "获取信息成功",
									Toast.LENGTH_LONG).show();
							// mWeiboInfoEdt.setText(response);

							Log.e("response", response);
							// 解析
							try {
								JSONObject jsonObj = new JSONObject(response);
								String statues = jsonObj.getString("statuses");
								JSONArray jsonArray = new JSONArray(statues);
								String info = jsonArray.get(0).toString();
								Log.e("info", statues);
								// 微博数组中第一条的微博对象
								JSONObject infoObj = new JSONObject(info);
								// 字段
								String createTime = infoObj
										.getString("created_at");
								String textContent = infoObj.getString("text");
								int repostCounts = infoObj
										.getInt("reposts_count");
								int commentdCounts = infoObj
										.getInt("comments_count");
								// 用户信息相关字段(user字段子对象)
								String user = infoObj.getString("user");
								JSONObject userObj = new JSONObject(user);
								// 用户名
								String userName = userObj.getString("name");
								// 头像链接
								mIconUrl = userObj
										.getString("profile_image_url");
								setImageView(mIconUrl);

								// mWeiboInfoEdt.setText(user);
								Log.e("iconUrl", mIconUrl);

								mWeiboInfoEdt.setText("用户名：" + userName
										+ "	创建时间:" + createTime + "	转发数："
										+ repostCounts + "	评论数："
										+ commentdCounts + "	头像链接" + mIconUrl);
							} catch (JSONException e) {
								e.printStackTrace();
							}

						}
					});
			break;
		default:
			break;
		}

	}

	protected void setImageView(String iconUrl) {
		new Thread(new Runnable() {
			Bitmap bitmap = null;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					URL myUrl = new URL(mIconUrl);
					Log.e("myUrl", myUrl + "");
					HttpURLConnection conn = (HttpURLConnection) myUrl
							.openConnection();
					InputStream is = conn.getInputStream();
					bitmap = BitmapFactory.decodeStream(is);
					runOnUiThread(new Runnable() {

						@Override
						public void run() {

							mIconIv.setImageBitmap(bitmap);
						}
					});
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}).start();
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
