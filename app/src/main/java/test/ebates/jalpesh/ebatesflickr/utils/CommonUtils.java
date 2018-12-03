package test.ebates.jalpesh.ebatesflickr.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CommonUtils {

    public static boolean checkWifiAndMobileConnection(Context context){
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = connMgr.getActiveNetworkInfo();
        return mobile!= null && mobile.isConnected() ;
    }
}
