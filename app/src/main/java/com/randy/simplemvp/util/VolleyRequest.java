package com.randy.simplemvp.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/19
 * Time: 19:13
 * Description: custom Volley request class
 */

public class VolleyRequest {

    private static RequestQueue mRequestQueue;

    public static void buildRequestQueue(Context context) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
    }

    public static VolleyRequest Instance() {
        if (mRequestQueue == null) {
            throw new NullPointerException("Call buildRequestQueue first.");
        }
        return new VolleyRequest();
    }

    public <T> GsonRequest<T> newGsonRequest(String url, Class<T> cls, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        GsonRequest<T> gsonRequest = new GsonRequest<>(url, cls, listener, errorListener);
        mRequestQueue.add(gsonRequest);
        return gsonRequest;
    }
}
