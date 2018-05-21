package com.sequoia.baoku.utils.netchangestate;

import java.util.Observable;

/**
 * Created by Administrator on 2018/5/3.
 */

public class InterNetObservable extends Observable {

    public static InterNetObservable interNetObservable = null;
    public static InterNetObservable getInterNetObservable(){
        if (interNetObservable == null){
            interNetObservable =  new InterNetObservable();
        }
        return interNetObservable;
    }

    public void notifyDataChange(NetWorkData netWorkData){
        setChanged();
        notifyObservers(netWorkData);
    }
}
