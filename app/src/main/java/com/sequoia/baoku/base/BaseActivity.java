package com.sequoia.baoku.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.sequoia.baoku.utils.netchangestate.InterNetObservable;
import com.sequoia.baoku.utils.netchangestate.InterNetObserver;
import com.sequoia.baoku.utils.netchangestate.NetWorkData;

import java.util.Observable;

/**
 * @author Administrator.
 * @date 2018/4/23.
 * @funtion
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog progressDialog = null;
    private InterNetObserver observer = new InterNetObserver(){
        @Override
        public void update(Observable observable, Object o) {
            super.update(observable, o);
            NetWorkData data =(NetWorkData) o;
            if (!data.isConnection()){
                toast("wang luo bu ke yong");
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setCancelable(false);
    }
    public abstract void initView(Bundle savedInstanceState);
    @Override
    public void showDialog() {
      progressDialog.show();
    }
    @Override
    public void hideDialog() {
      progressDialog.hide();
    }
    @Override
    public void toast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        InterNetObservable.getInterNetObservable().addObserver(observer);
    }
    @Override
    protected void onStop() {
        super.onStop();
        InterNetObservable.getInterNetObservable().deleteObserver(observer);
    }
}
