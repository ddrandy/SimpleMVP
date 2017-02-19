package com.randy.simplemvp.view.activity;

import android.widget.ListView;

import com.randy.simplemvp.R;
import com.randy.simplemvp.adapter.JokeAdapter;
import com.randy.simplemvp.entity.Joke;
import com.randy.simplemvp.entity.JokeInfo;
import com.randy.simplemvp.presenter.impl.JokePresenterImpl;
import com.randy.simplemvp.view.JokeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:01
 * Description: TODO
 */

public class MainActivity extends BaseActivity implements JokeView {
    public static final String P_NUM = "1";
    public static final String P_SIZE = "20";

    @BindView(R.id.list_view)
    ListView mListView;

    private List<JokeInfo> mJokeInfoList;
    private JokePresenterImpl mJokePresenter;
    private JokeAdapter mJokeAdapter;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mJokeInfoList = new ArrayList<>();
        mJokePresenter = new JokePresenterImpl(this);
        mJokeAdapter = new JokeAdapter(this, mJokeInfoList);
        mListView.setAdapter(mJokeAdapter);
        refreshData(P_NUM, P_SIZE);
    }

    private void refreshData(String pNum, String pSize) {
        mJokePresenter.getJoke(pNum, pSize);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void setJoke(Joke joke) {
        if (joke != null) {
            Joke.ResultBean result = joke.getResult();
            if (result != null) {
                mJokeInfoList.addAll(result.getList());
                mJokeAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void loading() {

    }

    @Override
    public void loaded() {

    }

    @Override
    public void onError() {

    }
}
