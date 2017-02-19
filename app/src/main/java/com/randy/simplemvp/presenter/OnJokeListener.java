package com.randy.simplemvp.presenter;

import com.randy.simplemvp.entity.Joke;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/19
 * Time: 20:05
 * Description: TODO
 */

public interface OnJokeListener {

    /**
     * 请求成功回调
     *
     * @param joke
     */
    void onSuccess(Joke joke);

    /**
     * 请求失败回调
     */
    void onError();
}
