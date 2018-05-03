package com.sexyhair.demoimitationmovie.common.netrequest;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sexyhair on 18/4/14.
 */

public interface MovieServiceForPath {
    @GET("{path}/pmovie?key=d5f379dc6df91313822cde900dd2dde5&city=北京")
    Observable<AppResponse> getPMovie(@Path("path") String path);
}
