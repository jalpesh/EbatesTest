package test.ebates.jalpesh.ebatesflickr;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {


    static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext=this;

        registerReceiversInApp();

    }

    private void registerReceiversInApp() {

    }

}
