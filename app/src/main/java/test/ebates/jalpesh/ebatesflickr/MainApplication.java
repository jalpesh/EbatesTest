package test.ebates.jalpesh.ebatesflickr;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {


    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext=this;

        registerReceiversInApp();

    }

    private void registerReceiversInApp(){

        //Register network listner so that when network comes back, refersh the list.

        //Register boot completed listner so that service can be run to fetch and keep latest data. Not current ly implementdd
    }

}
