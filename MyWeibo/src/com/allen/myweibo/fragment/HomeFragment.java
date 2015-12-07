package com.allen.myweibo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.allen.myweibo.R;
import com.allen.myweibo.adapter.ListViewAdapter;

/**
 * 首页
 * 
 */
public class HomeFragment extends Fragment {

	private ListView mListView;
	private View mHomeView;

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
	}

	private void initViews() {
		ListViewAdapter adapter = new ListViewAdapter(getActivity());
		View headView = LayoutInflater.from(getActivity()).inflate(
				R.layout.header_home, null);
		mListView.addHeaderView(headView);
		mListView.setAdapter(adapter);
		
	}

	private void setListeners() {
	}

}
