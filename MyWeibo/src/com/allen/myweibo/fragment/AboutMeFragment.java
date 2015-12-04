package com.allen.myweibo.fragment;

import com.allen.myweibo.R;
import com.allen.myweibo.activity.SettingsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 个人
 * 
 * @author hadoop
 * 
 */
public class AboutMeFragment extends Fragment implements OnClickListener {

	private View mLayoutView;
	private TextView mSettingTv;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mLayoutView = inflater.inflate(R.layout.fragment_profile, null);
		findViews();
		setListeners();
		return mLayoutView;
	}

	private void findViews() {
		mSettingTv = (TextView) mLayoutView
				.findViewById(R.id.profile_tv_settings);
	}

	private void setListeners() {
		mSettingTv.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.profile_tv_settings:
			getActivity().startActivity(
					new Intent(getActivity(), SettingsActivity.class));
			break;

		default:
			break;
		}
	}

}
