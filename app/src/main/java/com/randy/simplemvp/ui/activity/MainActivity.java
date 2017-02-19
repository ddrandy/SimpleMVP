package com.randy.simplemvp.ui.activity;

import android.widget.ListView;

import com.randy.simplemvp.R;
import com.randy.simplemvp.ui.BaseActivity;

import butterknife.BindView;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:01
 * Description: TODO
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.list_view)
    ListView mListView;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }
}
