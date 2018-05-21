package com.sequoia.baoku.app;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import com.sequoia.baoku.utils.netchangestate.InterNetStateBroadcastReceiver;

/**
 * @author Administrator.
 * @date 2018/4/24.
 * @funtion
 */

public class App extends Application {
    private Context mContext;
    private InterNetStateBroadcastReceiver broadcastReceiver = new InterNetStateBroadcastReceiver();
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGE");
        intentFilter.addAction("android.net.conn.STATE_CHANGE");
        registerReceiver(broadcastReceiver,intentFilter);

    }
}
