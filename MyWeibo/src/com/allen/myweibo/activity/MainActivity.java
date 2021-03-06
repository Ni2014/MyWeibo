package com.allen.myweibo.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.allen.myweibo.R;
import com.allen.myweibo.adapter.ViewPagerAdapter;

public class MainActivity extends BaseActivity implements OnClickListener,
		OnLongClickListener {

	private ViewPager mViewPager;
	private RadioGroup mTabRg;
	private RadioButton mHomeRb, mMessageRb, mDiscoverRb, mProfileRb;
	private ImageView mPlusIv;

	public static final int TAB_HOME = 0;
	public static final int TAB_MESSAGE = 1;
	public static final int TAB_DISCOVER = 2;
	public static final int TAB_PROFILE = 3;
	public static final int TAB_SETTING = 4;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void findViews() {
		mViewPager = (ViewPager) findViewById(R.id.main_vp_viewpager);
		mTabRg = (RadioGroup) findViewById(R.id.main_rg_menu);
		mHomeRb = (RadioButton) findViewById(R.id.main_rb_home);
		mMessageRb = (RadioButton) findViewById(R.id.main_rb_message);
		mPlusIv = (ImageView) findViewById(R.id.main_iv_plus);
		mDiscoverRb = (RadioButton) findViewById(R.id.main_rb_discover);
		mProfileRb = (RadioButton) findViewById(R.id.main_rb_profile);
	}

	@Override
	protected void initParams() {
		initViewPager();
		setListeners();
	}

	@SuppressWarnings("deprecation")
	private void initViewPager() {
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(
				getSupportFragmentManager());
		mHomeRb.setChecked(true);
		mViewPager.setAdapter(viewPagerAdapter);
		mViewPager.setOffscreenPageLimit(4);
		mViewPager.setCurrentItem(TAB_HOME);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case TAB_HOME:
					mViewPager.setCurrentItem(TAB_HOME);
					mHomeRb.setChecked(true);
					break;
				case TAB_MESSAGE:
					mViewPager.setCurrentItem(TAB_MESSAGE);
					mMessageRb.setChecked(true);
					break;
				case TAB_DISCOVER:
					mViewPager.setCurrentItem(TAB_DISCOVER);
					mDiscoverRb.setChecked(true);
					break;
				case TAB_PROFILE:
					mViewPager.setCurrentItem(TAB_PROFILE);
					mProfileRb.setChecked(true);
					break;
				// case TAB_SETTING:
				// mViewPager.setCurrentItem(TAB_SETTING);
				// break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void setListeners() {
		mPlusIv.setOnClickListener(this);
		mPlusIv.setOnLongClickListener(this);
		mTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.main_rb_home:
					mViewPager.setCurrentItem(TAB_HOME, false);
					break;
				case R.id.main_rb_message:
					mViewPager.setCurrentItem(TAB_MESSAGE, false);
					break;
				case R.id.main_rb_discover:
					mViewPager.setCurrentItem(TAB_DISCOVER, false);
					break;
				case R.id.main_rb_profile:
					mViewPager.setCurrentItem(TAB_PROFILE, false);
					break;

				default:
					break;
				}
			}
		});
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.main_iv_plus:
			startActivity(new Intent(getApplicationContext(),
					PopupActivity.class));
			break;

		default:
			break;
		}
	}

	@Override
	public boolean onLongClick(View view) {
		switch (view.getId()) {
		case R.id.main_iv_plus:
			startActivity(new Intent(MainActivity.this,
					SendTextWeiboActivity.class));
			break;

		default:
			break;
		}
		return false;
	}

}
