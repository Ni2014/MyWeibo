package com.allen.myweibo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allen.myweibo.R;

public class PopupActivity extends Activity implements OnClickListener {
	private ImageView mCloseIv, mTextWeiboIv, mPicWeiboIv, mLongWeiboTv,
			mLbsIv, mCommentsIv, mMoreIv;
	private LinearLayout mTextLlyt, mPicLlyt, mLongWeiboLiyt, mLbsLlyt,
			mCommentsLlyt, mMoreLlyt;

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
		mTextWeiboIv = (ImageView) findViewById(R.id.popup_iv_text_weibo);
		mPicWeiboIv = (ImageView) findViewById(R.id.popup_iv_pic_weibo);
		mLongWeiboTv = (ImageView) findViewById(R.id.popup_iv_long_weibo);
		mLbsIv = (ImageView) findViewById(R.id.popup_iv_lbs_weibo);
		mCommentsIv = (ImageView) findViewById(R.id.popup_iv_comments_weibo);
		mMoreIv = (ImageView) findViewById(R.id.popup_iv_more_weibo);
		mTextLlyt = (LinearLayout) findViewById(R.id.popup_llyt_text_weibo);
		mPicLlyt = (LinearLayout) findViewById(R.id.popup_llyt_pic_weibo);
		mLongWeiboLiyt = (LinearLayout) findViewById(R.id.popup_llyt_long_weibo);
		mLbsLlyt = (LinearLayout) findViewById(R.id.popup_llyt_lbs_weibo);
		mCommentsLlyt = (LinearLayout) findViewById(R.id.popup_llyt_comments_weibo);
		mMoreLlyt = (LinearLayout) findViewById(R.id.popup_llyt_more_weibo);
	}

	private void setListeners() {
		mCloseIv.setOnClickListener(this);
		mTextWeiboIv.setOnClickListener(this);
		mPicWeiboIv.setOnClickListener(this);
		mLongWeiboTv.setOnClickListener(this);
		mLbsIv.setOnClickListener(this);
		mCommentsIv.setOnClickListener(this);
		mMoreIv.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.popup_iv_close:
			finish();
			break;
		case R.id.popup_iv_text_weibo:
			setEnLargeAnimation(mTextLlyt);
			startActivity(new Intent(PopupActivity.this,
					SendTextWeiboActivity.class));

			break;
		case R.id.popup_iv_pic_weibo:
			setEnLargeAnimation(mPicLlyt);

			break;
		case R.id.popup_iv_long_weibo:
			setEnLargeAnimation(mLongWeiboLiyt);

			break;
		case R.id.popup_iv_lbs_weibo:
			setEnLargeAnimation(mLbsLlyt);

			break;
		case R.id.popup_iv_comments_weibo:
			setEnLargeAnimation(mCommentsLlyt);

			break;
		case R.id.popup_iv_more_weibo:
			setEnLargeAnimation(mMoreLlyt);

			break;

		default:
			break;
		}
	}

	private void setEnLargeAnimation(ViewGroup viewGroup) {
		ScaleAnimation scaleAni = new ScaleAnimation(1f, 1.2f, 1f, 1.2f);
		scaleAni.setDuration(80);
		viewGroup.startAnimation(scaleAni);

	}

}
