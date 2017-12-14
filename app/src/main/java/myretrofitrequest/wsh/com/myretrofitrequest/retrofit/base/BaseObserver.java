package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.DataEncryptionUtil;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.ResponseListener;
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

    }

    public BaseObserver<E> setExpectReturnType(Type classType) {
        this.expectReturnType = classType;
        return this;
    }
}
