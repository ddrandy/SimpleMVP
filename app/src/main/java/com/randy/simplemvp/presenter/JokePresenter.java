package com.randy.simplemvp.presenter;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/19
 * Time: 20:02
 * Description: joke presenter
 */

public interface JokePresenter {
    /**
     * 请求获取笑话数据
     *
     * @param pNum  第几页
     * @param pSize 数量
     */
    void getJoke(String pNum, String pSize);
}
