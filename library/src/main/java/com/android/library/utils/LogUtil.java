package com.android.library.utils;

import android.util.Log;

import com.android.library.Constants;

import java.util.Locale;

/**
 * Created by dugang on 2015/10/09. 日志输出工具类
 */
public class LogUtil {
    public static void i(String format, Object... args) {
        if (Constants.debug) {
            Log.i(getLogTag(), (args == null) ? format : String.format(Locale.US, format, args));
        }
    }

    public static void d(String format, Object... args) {
        if (Constants.debug) {
            Log.d(getLogTag(), (args == null) ? format : String.format(Locale.US, format, args));
        }
    }

    public static void w(String format, Object... args) {
        if (Constants.debug) {
            Log.w(getLogTag(), (args == null) ? format : String.format(Locale.US, format, args));
        }
    }

    public static void e(String format, Object... args) {
        if (Constants.debug) {
            Log.e(getLogTag(), (args == null) ? format : String.format(Locale.US, format, args));
        }
    }

    /**
     * 获取日志标签
     */
    private static String getLogTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
        String className = "unknown";
        String methodName = "unknown";
        int lineNumber = 0;
        for (int i = 0; i < trace.length; i++) {
            String fullPath = trace[i].getClassName();
            className = fullPath.substring(fullPath.lastIndexOf(".") + 1, fullPath.length());
            if (!className.equals(LogUtil.class.getSimpleName()) && !className.startsWith("Base")) {
                methodName = trace[i].getMethodName();
                lineNumber = trace[i].getLineNumber();
                break;
            }
        }
        return String.format(Locale.US, "%s[%s:%d]", className, methodName, lineNumber);
    }
}
