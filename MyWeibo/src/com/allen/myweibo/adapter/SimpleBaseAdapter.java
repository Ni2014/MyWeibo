package com.allen.myweibo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class SimpleBaseAdapter<T> extends BaseAdapter {
	protected Context c = null;

	protected LayoutInflater layoutInflater = null;

	protected List<T> datas = null;

	public SimpleBaseAdapter(Context c, List<T> datas) {
		this.c = c;
		this.datas = datas;
		layoutInflater = LayoutInflater.from(c);
	}

	/**
	 * 刷新适配器数据源
	 * 
	 * @param datas
	 */
	public void refreshDatas(List<T> datas) {
		this.datas = datas;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return datas != null ? datas.size() : 0;
	}

	@Override
	public T getItem(int position) {
		return datas != null ? datas.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public abstract View getView(int position, View convertView,
			ViewGroup parent);

}
