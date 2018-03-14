package com.john.history.history.bean;

import android.content.Context;

/**
 * Created by Administrator on 2018/3/9.
 */

public class SingleInstance {
    public static Context mContext;
    private static SingleInstance mSingleInstance;
    public int anInt;
    private SingleInstance() {
    }
    public static SingleInstance getInstance(){
        if(mSingleInstance==null) {
            mSingleInstance=new SingleInstance();
            return mSingleInstance;
        }else{
            return mSingleInstance;
        }
    }
    public void setmContext(Context activity,int a){
        mContext=activity;
        anInt=a;
    }
}
