package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base;

import android.net.ParseException;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import myretrofitrequest.wsh.com.myretrofitrequest.MyApp;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.DataEncryptionUtil;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.ResponseListener;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;

/**
 * BaseObserver
 * <p>
 * Created by Mr.w on 2017/12/11.
 * <p>
 * 版本      ${version}
 * <p>
 * 修改时间
 * <p>
 * 修改内容
 */


public class BaseObserver<E extends BaseResponse> implements Observer<E> {

    private ResponseListener responseListener;
    private Type expectReturnType;

    public BaseObserver(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    @Override
    public void onCompleted() {
        Log.v("request", "complete");
    }

    @Override
    public void onError(Throwable throwable) {
        handleError(throwable);
    }

    @Override
    public void onNext(E response) {
        //处理data数据
        if (response.getType().equals("E")) {

        } else if (response.getType().equals("F")) {

        } else if (response.getType().equals("T")) {
            //得到的data
            String result = DataEncryptionUtil.decodeData(response.getData());
            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(result);
                int code = jsonObject.getInt("code");
                if (code == 0) {
                    Object tClass = gson.fromJson(jsonObject.getString("data"), expectReturnType);
                    ResultEntity resultEntity = new ResultEntity(0, tClass, "");
                    this.responseListener.success(resultEntity);
                } else if (code == -1) {

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleError(Throwable throwable) {
        if (throwable instanceof UnknownHostException) {
            Toast.makeText(MyApp.getInstance(), "没有联网哦", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof HttpException) {
            Toast.makeText(MyApp.getInstance(), "网络错误", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof ConnectException) {
            Toast.makeText(MyApp.getInstance(), "连接失败", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException
                || throwable instanceof ParseException) {
            Toast.makeText(MyApp.getInstance(), "数据解析有误", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof TimeoutException) {
            Toast.makeText(MyApp.getInstance(), "连接超时", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MyApp.getInstance(), "未知错误", Toast.LENGTH_SHORT).show();
        }
    }

    public BaseObserver<E> setExpectReturnType(Type classType) {
        this.expectReturnType = classType;
        return this;
    }
}
