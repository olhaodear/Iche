package com.android.bmob;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by dugang on 2016/02/14.Bmob初始化话
 */
public class BmobApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Bmob.initialize(getApplicationContext(), "aaad1b1823b83a9a48b6e6ce6e745633");
    }
}
