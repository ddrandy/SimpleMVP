package com.randy.simplemvp.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.randy.simplemvp.entity.Joke;
import com.randy.simplemvp.model.JokeModel;
import com.randy.simplemvp.presenter.OnJokeListener;
import com.randy.simplemvp.util.VolleyRequest;

import static com.randy.simplemvp.util.Constants.APPKEY;
import static com.randy.simplemvp.util.Constants.REQUEST_SERVER_URL;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:34
 * Description: TODO
 */

public class JokeModelImpl implements JokeModel {
    @Override
    public void getJoke(String pNum, String pSize, final OnJokeListener jokeListener) {
        String url = REQUEST_SERVER_URL + "?pagenum=" + pNum + "&pagesize=" + pSize + "&sort=addtime&appkey=" + APPKEY;
        VolleyRequest.newInstance().newGsonRequest(url, Joke.class, new Response.Listener<Joke>() {
            @Override
            public void onResponse(Joke joke) {
                if (joke == null) {
                    jokeListener.onError();
                } else {
                    jokeListener.onSuccess(joke);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                jokeListener.onError();
            }
        });
    }
}
