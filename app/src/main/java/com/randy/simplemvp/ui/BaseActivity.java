package com.randy.simplemvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.randy.simplemvp.util.LogUtil;
import com.randy.simplemvp.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 18:44
 * Description: super class of all activities
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mUnBinder = ButterKnife.bind(this, this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        mUnBinder.unbind();
        super.onDestroy();
    }

    /**
     * init view
     */
    protected abstract void initView();

    /**
     * init data and variables
     */
    protected abstract void initData();

    /**
     * get layout res id
     *
     * @return R.layout.[res ID]
     */
    protected abstract int getLayoutResId();

    /**
     * show toast
     *
     * @param msg toast message
     */
    protected void toast(String msg) {
        ToastUtil.showS(msg);
    }

    /**
     * show log
     *
     * @param msg log message
     */
    protected void logD(String msg) {
        LogUtil.logD(getClass().getSimpleName(), msg);
    }
}
