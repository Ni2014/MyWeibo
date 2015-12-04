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
	private View mView;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.fragment_home, null);
		initViews();
		return mView;
	}

	private void initViews() {
		mListView = (ListView) mView.findViewById(R.id.home_lv_weibo);
		ListViewAdapter adapter = new ListViewAdapter(getActivity());
		mListView.setAdapter(adapter);
	}
}
