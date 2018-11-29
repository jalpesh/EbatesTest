package test.ebates.jalpesh.ebatesflickr.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import test.ebates.jalpesh.ebatesflickr.MainApplication;

public class CommonUtils {

    public static boolean checkWifiAndMobileConnection(){
        ConnectivityManager connMgr = (ConnectivityManager) MainApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = connMgr.getActiveNetworkInfo();
        return mobile!= null && mobile.isConnected() ;
    }
}
