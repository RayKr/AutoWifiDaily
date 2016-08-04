package com.swroom.autowifidaily;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by Ray on 2016/8/2.
 */
public class NetReceiver extends BroadcastReceiver {

    private final String TAG = ".NetReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "---------------------------------------------------------------");

        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {

            // 获取通知
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            // 根据wifi状态做区分
            NetworkInfo.State state = info.getState();
            if (state == NetworkInfo.State.CONNECTED) { // wifi接入

                // 获取wifi网络状态
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();

                // 根据通知的wifi的ssid和设定的对比
                Log.d(TAG, wifiInfo.toString());
                Log.d(TAG, "当前wifi的SSID="+wifiInfo.getBSSID());

                new Runnable() {
                    @Override
                    public void run() {

                    }
                };

            } else if (state == NetworkInfo.State.DISCONNECTED) {
                Log.d(TAG, "wifi连接断开！");
            }
        }

    }


}
