package com.sequoia.baoku.utils.netchangestate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.sequoia.baoku.base.BaseView;

/**
 * Created by Administrator on 2018/5/3.
 */

public class InterNetStateBroadcastReceiver extends BroadcastReceiver {
    private NetWorkData netWorkData = new NetWorkData();
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION == intent.getAction()) {
            ConnectivityManager manager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                if (info.isConnected()) {
                    netWorkData.setConnection(true);
                    //panduan wang luo keyong nukeyong
                    if (info.isAvailable()) {
                        if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                            netWorkData.setWifi(true);
                            InterNetObservable.getInterNetObservable().notifyDataChange(netWorkData);
                        }
                        if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                            netWorkData.setMobile(true);
                            InterNetObservable.getInterNetObservable().notifyDataChange(netWorkData);
                        }
                    }else {
                        Toast.makeText(context, "当前网络bukeyong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    netWorkData.setConnection(false);
                    netWorkData.setMobile(false);
                    netWorkData.setWifi(false);
                    InterNetObservable.getInterNetObservable().notifyDataChange(netWorkData);
                    Toast.makeText(context, "当前没有网络连接", Toast.LENGTH_SHORT).show();
                }
            }else {
                netWorkData.setConnection(false);
                netWorkData.setMobile(false);
                netWorkData.setWifi(false);
                InterNetObservable.getInterNetObservable().notifyDataChange(netWorkData);
                Toast.makeText(context, "当前没有网络连接，请确保你已经打开网络", Toast.LENGTH_SHORT).show();
            }

        }


    }
}
