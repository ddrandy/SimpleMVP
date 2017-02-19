package com.randy.simplemvp.util;

import android.app.Application;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 18:36
 * Description: Joke application
 */

public class JokeApp extends Application {

    public static JokeApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        // get application context
        mInstance = this;

        // init volley
        VolleyRequest.buildRequestQueue(this);
    }
}
