package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.api;


import java.util.concurrent.TimeUnit;

import myretrofitrequest.wsh.com.myretrofitrequest.bean.LoginInfo;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base.BaseResponse;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.Cache;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 定义Retrofit请求的method/param等。
 * Created by huanzhang on 2016/4/11.
 */
public interface RetrofitApi {

    @POST("index.php?alg=md5_v2&client_id=by565fa4facdb191")
    Observable<BaseResponse<LoginInfo>> login(@Query("type") String type, @Query("username") String username,
                                              @Query("password") String password);

    //alg=md5_v2&client_id=by565fa4facdb191&app_version=101&from=android&time=121545664&notify_id=135451534
    @Cache(time = 10,timeUnit = TimeUnit.SECONDS)
    @GET("index.php")
    Observable<BaseResponse<LoginInfo>> login2(@Query("data") String data, @Query("type") String type, @Query("api_ver") String api_ver);
}