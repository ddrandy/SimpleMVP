package com.randy.simplemvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.randy.simplemvp.R;
import com.randy.simplemvp.entity.JokeInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/19
 * Time: 20:57
 * Description: TODO
 */

public class JokeAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<JokeInfo> mJokeInfoList;

    public JokeAdapter(Context context, List<JokeInfo> jokeInfoList) {
        mContext = context;
        mJokeInfoList = jokeInfoList;
    }

    @Override
    public int getCount() {
        return mJokeInfoList == null ? 0 : mJokeInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mJokeInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.list_item_joke, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.setData(mJokeInfoList.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_joke_content)
        TextView mTvJokeContent;
        @BindView(R.id.tv_joke_add_time)
        TextView mTvJokeAddTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void setData(JokeInfo data) {
            mTvJokeAddTime.setText(data.getAddtime());
            mTvJokeContent.setText(data.getContent());
        }
    }
}
