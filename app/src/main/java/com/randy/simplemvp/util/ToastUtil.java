package com.randy.simplemvp.util;

import android.annotation.SuppressLint;
import android.widget.Toast;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/16
 * Time: 14:52
 * Description: Toast util
 */

public class ToastUtil {
    private static Toast toast;

    public static void showS(String string) {
        getToast(string, Toast.LENGTH_SHORT).show();
    }

    public static void showL(String string) {
        getToast(string, Toast.LENGTH_LONG).show();
    }

    @SuppressLint("ShowToast")
    private static Toast getToast(String string, int duration) {
        if (toast == null) {
            toast = Toast.makeText(JokeApp.mInstance, string, duration);
        } else {
            toast.setText(string);
        }
        return toast;
    }
}
