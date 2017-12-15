package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2017/12/14.
 */

public class NetUtils {
    public static boolean isConnectNet(Context context){
        if (context!=null){
            ConnectivityManager conManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = conManager.getActiveNetworkInfo();
            return networkInfo == null ? false : networkInfo.isAvailable();
        }
        return true;
    }
}
