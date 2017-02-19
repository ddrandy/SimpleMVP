package com.randy.simplemvp.util;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/19
 * Time: 19:31
 * Description: gson parser request
 */

@SuppressWarnings("unused")
public class GsonRequest<T> extends Request<T> {

    private Class<T> mCls;
    private Gson mGson = new Gson();
    private Response.Listener<T> mListener;
    private TypeToken<T> mTypeToken;

    public GsonRequest(int method, String url, Class<T> cls, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mCls = cls;
        mListener = listener;
    }

    public GsonRequest(String url, Class<T> cls, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, cls, listener, errorListener);
    }

    public GsonRequest(int method, String url, TypeToken<T> typeToken, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mTypeToken = typeToken;
        mListener = listener;
    }

    public GsonRequest(String url, TypeToken<T> typeToken, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, url, typeToken, listener, errorListener);
    }


    @SuppressWarnings("unchecked")
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String stringJson = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            if (mTypeToken == null) {
                return Response.success(mGson.fromJson(stringJson, mCls),
                        HttpHeaderParser.parseCacheHeaders(response));
            } else {
                return (Response<T>) Response.success(mGson.fromJson(stringJson, mTypeToken.getType()),
                        HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
