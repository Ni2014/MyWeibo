package com.allen.myweibo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.allen.myweibo.R;
import com.allen.myweibo.activity.WeiboTestActivity;
import com.allen.myweibo.adapter.ListViewAdapter;

/**
 * 首页
 * 
 */
public class HomeFragment extends Fragment implements OnClickListener {

	private ListView mListView;
	private View mHomeView;
	private ImageView mTestIv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mHomeView = inflater.inflate(R.layout.fragment_home, null);
		findViews();
		initViews();
		setListeners();
		return mHomeView;
	}

	private void findViews() {
		mListView = (ListView) mHomeView.findViewById(R.id.home_lv_weibo);
		mTestIv = (ImageView) mHomeView.findViewById(R.id.home_iv_friendattention);
	}

	private void initViews() {
		ListViewAdapter adapter = new ListViewAdapter(getActivity());
		View headView = LayoutInflater.from(getActivity()).inflate(
				R.layout.header_home, null);
		mListView.addHeaderView(headView);
		mListView.setAdapter(adapter);
		
	}

	private void setListeners() {
		mTestIv.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.home_iv_friendattention:
			startActivity(new Intent(getActivity(), WeiboTestActivity.class));
			break;
			

		default:
			break;
		}
	}

}
