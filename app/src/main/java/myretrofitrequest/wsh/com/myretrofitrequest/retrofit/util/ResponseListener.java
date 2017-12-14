package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util;

import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base.ResultEntity;

/**
 * ResponseListener
 * <p>
 * Created by Mr.w on 2017/12/13.
 * <p>
 * 版本      ${version}
 * <p>
 * 修改时间
 * <p>
 * 修改内容
 */


public interface ResponseListener {
    void success(ResultEntity resultEntity);
    void fail(ResultEntity resultEntity);
}
