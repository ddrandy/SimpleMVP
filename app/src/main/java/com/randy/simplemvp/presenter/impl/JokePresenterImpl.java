package com.randy.simplemvp.presenter.impl;

import com.randy.simplemvp.entity.Joke;
import com.randy.simplemvp.model.impl.JokeModelImpl;
import com.randy.simplemvp.presenter.JokePresenter;
import com.randy.simplemvp.presenter.OnJokeListener;
import com.randy.simplemvp.view.JokeView;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/19
 * Time: 20:15
 * Description: TODO
 */

public class JokePresenterImpl implements JokePresenter, OnJokeListener {

    private final JokeModelImpl mJokeModel = new JokeModelImpl();

    private final JokeView mJokeView;

    public JokePresenterImpl(JokeView jokeView) {
        mJokeView = jokeView;
    }

    @Override
    public void getJoke(String pNum, String pSize) {
        mJokeView.loading();
        mJokeModel.getJoke(pNum, pSize, this);
    }

    @Override
    public void onSuccess(Joke joke) {
        mJokeView.loaded();
        mJokeView.setJoke(joke);
    }

    @Override
    public void onError() {
        mJokeView.loaded();
        mJokeView.onError();
    }
}
