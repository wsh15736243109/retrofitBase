package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import myretrofitrequest.wsh.com.myretrofitrequest.MyApp;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base.BaseResponse;
import myretrofitrequest.wsh.com.myretrofitrequest.bean.LoginInfo;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base.ResultEntity;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base.BaseObserver;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.ResponseListener;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util.BuilMapUtils.hashMapToBase64;

/**
 * UserPrestener
 * <p>
 * Created by Mr.w on 2017/12/11.
 * <p>
 * 版本      ${version}
 * <p>
 * 修改时间
 * <p>
 * 修改内容
 */


public class UserPrestener<T> extends Observable  {

    public UserPrestener(Observer observer) {
        this.addObserver(observer);
    }

    public void login2(String username, String phone, String country) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", phone);
        map.put("country", country);
        String param = hashMapToBase64(map);
        rx.Observable<BaseResponse<LoginInfo>> observable = MyApp.getInstance().getmIApi().login2(param, "By_User_login", "104");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserver<BaseResponse<LoginInfo>>(new ResponseListener() {
            @Override
            public void success(ResultEntity resultEntity) {
                setChangedAndNotifyObservers(resultEntity);
            }

            @Override
            public void fail(ResultEntity resultEntity) {
                setChangedAndNotifyObservers(resultEntity);
            }
        }).setExpectReturnType(LoginInfo.class));
    }

    public void setChangedAndNotifyObservers(Object ob ){
        UserPrestener.this.setChanged();
        UserPrestener.this.notifyObservers(ob);
    }
}
