package myretrofitrequest.wsh.com.myretrofitrequest;

import android.app.Application;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.api.RetrofitApi;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static myretrofitrequest.wsh.com.myretrofitrequest.retrofit.cache.CacheInterceptor.interceptor;
import static myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.BuilMapUtils.getStamp;

/**
 * MyApp
 * <p>
 * Created by Mr.w on 2017/12/13.
 * <p>
 * 版本      ${version}
 * <p>
 * 修改时间
 * <p>
 * 修改内容
 */


public class MyApp extends Application {
    private Retrofit mRetrofit;

    public static MyApp instance;
    private RetrofitApi mIApi;

    public RetrofitApi getmIApi() {
        return mIApi;
    }

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRetrofit();
    }

    private void initRetrofit() {
//cache url
        File httpCacheDirectory = new File(getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

//        作者：wanbo_
//        链接：http://www.jianshu.com/p/e3d32c016c32
//        來源：简书
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient();
        okhttp3.OkHttpClient.Builder clientBuilder = okHttpClient.newBuilder()
                //添加通用请求信息
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl.Builder builder = request.url().newBuilder()
                                .addQueryParameter("alg", "md5_v2")
                                .addQueryParameter("client_id", "by565fa4facdb191")
                                .addQueryParameter("app_version", "101")
                                .addQueryParameter("from", "android")
                                .addQueryParameter("time", getStamp())
                                .addQueryParameter("notify_id", getStamp());
//                        //存在可能取不到Token的情况，所以只在有信息的时候调用getToken，否则传空。
                        request = request.newBuilder().url(builder.build()).build();
                        return chain.proceed(request);
                    }
                })
                .retryOnConnectionFailure(true);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.v("request", "addInterceptor" + message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addNetworkInterceptor(logging);
        okHttpClient = clientBuilder
                .addInterceptor(interceptor)
                .addNetworkInterceptor(interceptor)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .cache(cache).build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://dev.sale.sunsunxiaoli.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mIApi = mRetrofit.create(RetrofitApi.class);
    }


}
