package com.randy.simplemvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 19:13
 * Description: joke entity
 */

public class Joke implements Parcelable {

    /**
     * status : 0
     * msg : ok
     * result : {"total":"35328","pagenum":"1","pagesize":"1","list":[{"content":"刚才肚子饿下去吃夜宵，遇见一刚下班的程序猿来吃晚饭，一脸落魄。我坐他旁边跟他说：年轻人，生活总是苦尽甘来有笑有泪的，你看我，我五点半就下班了。","addtime":"2016-05-19 16:59:40","url":"http://m.kaixinhui.com/detail-38125.html"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Parcelable {
        /**
         * total : 35328
         * pagenum : 1
         * pagesize : 1
         * list : [{"content":"刚才肚子饿下去吃夜宵，遇见一刚下班的程序猿来吃晚饭，一脸落魄。我坐他旁边跟他说：年轻人，生活总是苦尽甘来有笑有泪的，你看我，我五点半就下班了。","addtime":"2016-05-19 16:59:40","url":"http://m.kaixinhui.com/detail-38125.html"}]
         */

        private String total;
        private String pagenum;
        private String pagesize;
        private List<JokeInfo> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPagenum() {
            return pagenum;
        }

        public void setPagenum(String pagenum) {
            this.pagenum = pagenum;
        }

        public String getPagesize() {
            return pagesize;
        }

        public void setPagesize(String pagesize) {
            this.pagesize = pagesize;
        }

        public List<JokeInfo> getList() {
            return list;
        }

        public void setList(List<JokeInfo> list) {
            this.list = list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.total);
            dest.writeString(this.pagenum);
            dest.writeString(this.pagesize);
            dest.writeTypedList(this.list);
        }

        public ResultBean() {
        }

        protected ResultBean(Parcel in) {
            this.total = in.readString();
            this.pagenum = in.readString();
            this.pagesize = in.readString();
            this.list = in.createTypedArrayList(JokeInfo.CREATOR);
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel source) {
                return new ResultBean(source);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.msg);
        dest.writeParcelable(this.result, flags);
    }

    public Joke() {
    }

    protected Joke(Parcel in) {
        this.status = in.readString();
        this.msg = in.readString();
        this.result = in.readParcelable(ResultBean.class.getClassLoader());
    }

    public static final Creator<Joke> CREATOR = new Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel source) {
            return new Joke(source);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };
}
