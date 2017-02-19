package com.randy.simplemvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:07
 * Description: joke info
 */

public class JokeInfo implements Parcelable {

    /**
     * content : 刚才肚子饿下去吃夜宵，遇见一刚下班的程序猿来吃晚饭，一脸落魄。我坐他旁边跟他说：年轻人，生活总是苦尽甘来有笑有泪的，你看我，我五点半就下班了。
     * addtime : 2016-05-19 16:59:40
     * url : http://m.kaixinhui.com/detail-38125.html
     */

    private String content;
    private String addtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeString(this.addtime);
    }

    public JokeInfo() {
    }

    protected JokeInfo(Parcel in) {
        this.content = in.readString();
        this.addtime = in.readString();
    }

    public static final Creator<JokeInfo> CREATOR = new Creator<JokeInfo>() {
        @Override
        public JokeInfo createFromParcel(Parcel source) {
            return new JokeInfo(source);
        }

        @Override
        public JokeInfo[] newArray(int size) {
            return new JokeInfo[size];
        }
    };
}
