package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.util;

import java.util.HashMap;

/**
 * BuilMapUtils
 * <p>
 * Created by Mr.w on 2017/12/13.
 * <p>
 * 版本      ${version}
 * <p>
 * 修改时间
 * <p>
 * 修改内容
 */


public class BuilMapUtils {
    public static String hashMapToBase64(HashMap<String, Object> object) {
        String param = new ParamDeal().dataEncrypt(object);
        return param;
    }

    /**
     * 字节数组转为普通字符串（ASCII对应的字符）
     *
     * @param bytearray byte[]
     * @return String
     */
    public static String bytetoString(byte[] bytearray) {
        String result = "";
        char temp;

        int length = bytearray.length;
        for (int i = 0; i < length; i++) {
            temp = (char) bytearray[i];
            result += temp;
        }
        return result;
    }

    /**
     * 获取当前时间戳
     *
     * @return int 类型数据
     */
    public static String getStamp() {
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
        return ts;
    }
}
