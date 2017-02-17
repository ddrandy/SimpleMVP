package com.randy.simplemvp.util;

import android.util.Log;

/**
 * Author: randy(dddrandy@gmail.com)
 * Date: 2017/2/17
 * Time: 18:49
 * Description: log util
 */

public class LogUtil {
    public static void logD(String tag, String msg) {
        if (Constants.DEBUG_MODE) {
            Log.d(tag, msg);
        }
    }
}
