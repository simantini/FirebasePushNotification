package com.android.pushnotificationpoc;

import android.app.Application;
import android.content.Context;

/**
 * Created by webonise on 28/3/18.
 */

public class MainApplication extends Application {
    private static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Context getAppContext() {
        return appContext;
    }
}
