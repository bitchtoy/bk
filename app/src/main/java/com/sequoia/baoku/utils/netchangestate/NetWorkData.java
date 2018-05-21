package com.sequoia.baoku.utils.netchangestate;

/**
 * Created by Administrator on 2018/5/3.
 */

public class NetWorkData {
    private boolean wifi;
    private boolean mobile;
    private boolean connection;

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }
}
