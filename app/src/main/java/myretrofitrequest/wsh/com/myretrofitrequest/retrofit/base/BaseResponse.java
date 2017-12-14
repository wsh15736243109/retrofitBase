package myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base;

import java.io.Serializable;

/**
 * @author Muyangmin
 * @since 1.0.0
 */
public class BaseResponse<T> implements Serializable {


    /**
     * client_id : by565fa4facdb191
     * time : 1513132970
     * data : ZXlKamIyUmxJam93TENKa1lYUmhJanA3SW1sa0lqb2lNVEl4SWl3aWRYTmxjbTVoYldVaU9pSnRYekUxTnpNMk1qUXpNVEE1SWl3aWNHRnpjM2R2Y21RaU9pSmpaVGcyTW1Rd1pUUXdNRFkxTVRRM01UZ3pNbUV4WVRSbFpqWmlOREF5T1NJc0ltMXZZbWxzWlNJNklqRTFOek0yTWpRek1UQTVJaXdpWTI5MWJuUnllVjl1YnlJNklpczROaUlzSW1WdFlXbHNJam9pTVRJME5qVTNPRGxBY1hFdVkyOXRJaXdpY21WblgzUnBiV1VpT2lJeE5EZ3pPVFF5TnpBNUlpd2ljbVZuWDJsd0lqb2lNVGc0TURJeU16azRNeUlzSW14aGMzUmZiRzluYVc1ZmRHbHRaU0k2SWpFMU1UTXhNekkyTnpJaUxDSnNZWE4wWDJ4dloybHVYMmx3SWpvaU56azBOamN4TWpFNElpd2lkWEJrWVhSbFgzUnBiV1VpT2lJeE5EZ3pPVFF5TnpBNElpd2ljM1JoZEhWeklqb2lNU0lzSW5KbFoxOW1jbTl0SWpvaU9UazVJaXdpWVhWMGIxOXNiMmRwYmw5amIyUmxJam9pWkdOaFpESXlZekUxT0RrMFpXWmtNREU1TTJKbE1qUXlOVEZoTVdSbE5Ua3lReUlzSW5WcFpDSTZJakV5TVNJc0luSmxZV3h1WVcxbElqb2lJaXdpYVdSdWRXMWlaWElpT2lJaUxDSnNibWNpT2lJd0xqQXdNREF3TUNJc0lteGhkQ0k2SWpBdU1EQXdNREF3SWl3aVoyVnZhR0Z6YUNJNklpSXNJbTVwWTJ0dVlXMWxJam9pWEhVMU5EZGtYSFUwWlRKa0lpd2ljMlY0SWpvaU1DSXNJbUpwY25Sb1pHRjVJam9pTUNJc0luRnhJam9pSWl3aWFHVmhaQ0k2SWpJM0lpd2ljMk52Y21VaU9pSXdJaXdpYkc5bmFXNGlPaUl3SWl3aWMybG5iaUk2SWx4MU5qSXhNVngxTmpZeVpseDFOMkkzWlZ4MU5UUXdaQ0lzSW1KblgybHRaeUk2SWpBaUxDSndZWGxmYzJWamNtVjBJam9pWlRFd1lXUmpNemswT1dKaE5UbGhZbUpsTlRabE1EVTNaakl3WmpnNE0yVWlMQ0p3YUc5dVpWOTJZV3hwWkdGMFpTSTZJakVpTENKbGJXRnBiRjkyWVd4cFpHRjBaU0k2SWpBaUxDSnBaR1Z1ZEdsMGVWOTJZV3hwWkdGMFpTSTZJakFpTENKcFpHTnZaR1VpT2lJeE5EZzBJaXdpWkdWbVlYVnNkRjloWkdSeVpYTnpJam9pT0RRM0lpd2laWGh3SWpvaU1DNHdJaXdpYVc1MmFYUmxYMmxrSWpvaU1DSXNJbmQ0YjNCbGJtbGtJam9pSWl3aWMzVmljMk55YVdKbFpDSTZJaUlzSW5kbGFYaHBiaUk2SWpFek5EZzBNemM1TWprd0lpd2lhbTlpWDNScGRHeGxJam9pWEhVNU1XTTNYSFU0WkRKa1hIVTFaVEE0SWl3aVkyOXRjR0Z1ZVNJNklseDFOamMyWkZ4MU5XUmtaVngxTlRNMVlWeDFOR1UxWmx4MU4yWTFNVngxTjJWa1kxeDFOemxrTVZ4MU5qSTRNRngxTmpjd09WeDFPVFkxTUZ4MU5URTJZMXgxTlRObU9DSXNJbXh2WTE5amIzVnVkSEo1SWpvaU1TSXNJbXh2WTE5aGNtVmhJam9pWEhVMFpUSmtYSFUxTm1aa0lGeDFObVExT1Z4MU5tTTFaaUJjZFRZM05tUmNkVFZrWkdVaUxDSmhiR2xpWVdsamFIVmhibDlwWkNJNklpMHhJaXdpZDNoaGNIQmZiM0JsYm1sa0lqb2lJaXdpYkc5bmFXNWZaR1YyYVdObFgyTnVkQ0k2SWpFaUxDSmhaR1J5WlhOeklqb2lJaXdpWTI5dWRHRmpkQ0k2SWlJc0ltRjFkR2hmWTI5a1pTSTZJazFVVlhoTmVrVjZUWHBuTTAxSk1sWnBiWEV3TUVnM1QzTnVkVEpyWWs0NVpHMXRRblJoV214emRVTnlZbGcyZEhKek5rZHJTSGxTYW5KeFQyRk1YQzlSYUdSeGVXNXplV1VpTENKeWIyeGxjMTlwYm1adklqcGJYU3dpYUdGelgyTm9ZWEpuWlNJNklqRWlMQ0pwYzE5emRHOXlaWE1pT2lJd0luMHNJbU5oWTJobElqcG1ZV3h6WlgwPQ==
     * notify_id : 135451534
     * type : T
     * sign : 1db752c7071d44ebc04e7a47188f50b8
     * api_ver : null
     */

    private String client_id;
    private String time;
    private String data;
    private String notify_id;
    private String type;
    private String sign;
    private String api_ver;



    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getApi_ver() {
        return api_ver;
    }

    public void setApi_ver(String api_ver) {
        this.api_ver = api_ver;
    }
}