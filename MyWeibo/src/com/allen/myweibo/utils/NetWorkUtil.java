package com.allen.myweibo.utils;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * 网络工具类
 */
public class NetWorkUtil {
	// 网络控制
	public static void controlNetWork(Context context, boolean enabled) {
		controlWifi(context, enabled);
	}

	// wifi控制
	public static void controlWifi(Context context, boolean enabled) {
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLING
				|| wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
			wifiManager.setWifiEnabled(enabled);
		} else {
			wifiManager.setWifiEnabled(enabled);
		}
	}

}
