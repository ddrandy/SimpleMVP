package com.randy.simplemvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.randy.simplemvp.util.LogUtil;
import com.randy.simplemvp.util.ToastUtil;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 18:44
 * Description: super class of all activities
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        initView();
        initData();
        initListener();
    }

    /**
     * show log
     *
     * @param msg log message
     */
    protected void logD(String msg) {
        LogUtil.logD(getClass().getSimpleName(), msg);
    }

    /**
     * show toast
     *
     * @param msg toast message
     */
    protected void toast(String msg) {
        ToastUtil.showS(msg);
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract int getLayoutResId();
}
