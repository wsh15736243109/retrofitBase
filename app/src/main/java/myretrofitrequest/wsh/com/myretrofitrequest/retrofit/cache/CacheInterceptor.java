package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.cache;

import android.util.Log;

import java.io.IOException;

import myretrofitrequest.wsh.com.myretrofitrequest.MyApp;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.NetUtils.isConnectNet;

/**
 * Created by Administrator on 2017/12/15.
 */

public class CacheInterceptor {
    public static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (!isConnectNet(MyApp.getInstance().getApplicationContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .url(request.url())
                        .build();
                Log.v("request",("暂无网络"));
            }

            Response response = chain.proceed(request);
            if (isConnectNet(MyApp.getInstance().getApplicationContext())) {
                int maxAge = 60 * 60; // read from cache for 1 minute
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;

//            作者：mrwangyong
//            链接：http://www.jianshu.com/p/3a8d910cce38
//            來源：简书
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        }
    };
}
