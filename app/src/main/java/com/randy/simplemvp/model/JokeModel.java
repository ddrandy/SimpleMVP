package com.randy.simplemvp.model;

import com.randy.simplemvp.presenter.OnJokeListener;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:31
 * Description: TODO
 */

public interface JokeModel {

    /**
     * 获取笑话内容
     *
     * @param pNum  page number
     * @param pSize page size
     */
    void getJoke(String pNum, String pSize, OnJokeListener jokeListener);
}
