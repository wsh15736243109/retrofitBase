package myretrofitrequest.wsh.com.myretrofitrequest;

import android.app.Application;
import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.api.RetrofitApi;

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

        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder clientBuilder = okHttpClient.newBuilder()
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
        okHttpClient = clientBuilder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://dev.sale.sunsunxiaoli.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mIApi = mRetrofit.create(RetrofitApi.class);
    }
}
