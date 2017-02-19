package com.randy.simplemvp.view;

import com.randy.simplemvp.entity.Joke;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:10
 * Description: joke view interface
 */

public interface JokeView {

    /**
     * 加载数据
     */
    void loading();

    /**
     * 加载完毕
     */
    void loaded();

    /**
     * 加载出错
     */
    void onError();

    /**
     * 设置数据
     */
    void setJoke(Joke joke);
}
