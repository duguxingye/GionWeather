package com.gion.app.weather.gionweather.util;

/**
 * Created by hua on 2015/9/2.
 */
public interface HttpCallBackListener {

    void onFinish(String response);
    void onError(Exception e);

}
