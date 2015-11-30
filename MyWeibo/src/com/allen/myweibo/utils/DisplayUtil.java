package com.allen.myweibo.utils;

import android.content.Context;

/**
 * 单位转换工具类
 * 
 * @author hadoop
 * 
 */
public class DisplayUtil {
	public static int px2dip(Context context, float pxValue) {
		// 得到相对密度（基线是160dp）
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static int dip2px(Context context, float dipValue) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
}
