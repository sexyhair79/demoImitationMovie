package com.sexyhair.demoimitationmovie.common.netrequest;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by sexyhair on 18/4/14.
 * http://op.juhe.cn/onebox/movie/pmovie?key=d5f379dc6df91313822cde900dd2dde5&city=北京
 * http://ip.taobao.com/service/getIpInfo.php?ip=59.108.54.37
 */

public interface MovieService {
    //    @GET("getIpInfo.php?ip=59.108.54.37")
    @GET("pmovie?key=d5f379dc6df91313822cde900dd2dde5&city=北京")
    Observable<AppResponse> getPMovies();
//    Call<AppResponse> getPMovies();
}
