package com.allen.myweibo.adapter;

import com.allen.myweibo.R;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewAdapter extends BaseAdapter {

	private Activity mActivity;

	public ListViewAdapter(Activity mActivity) {
		super();
		this.mActivity = mActivity;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mActivity.getLayoutInflater().inflate(R.layout.item_home_listview, null);
		return convertView;
	}

}
