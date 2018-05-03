package com.sexyhair.demoimitationmovie.common.netrequest;

/**
 * Created by sexyhair on 18/4/14.
 * "reason":"查询成功",
 * "result":{
 * "title":"北京影讯_最近上映电影",
 * "url":"http:\/\/theater.mtime.com\/China_Beijing\/",
 * "m_url":"http:\/\/m.mtime.cn\/?cityId=290",
 * "data":[],
 * "morelink":"http:\/\/theater.mtime.com\/China_Beijing\/",
 * "date":"2018-04-14"
 * },
 * "error_code":0
 */

public class AppResponse<T> {
    private int error_code;
    private String reason;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
