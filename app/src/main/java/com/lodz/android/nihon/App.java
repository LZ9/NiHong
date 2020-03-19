package com.lodz.android.nihon;


import android.content.Context;

import androidx.multidex.MultiDex;

import com.lodz.android.pandora.base.application.BaseApplication;

/**
 * Application
 * Created by zhouL on 2017/2/18.
 */
public class App extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onStartCreate() {

    }
}
