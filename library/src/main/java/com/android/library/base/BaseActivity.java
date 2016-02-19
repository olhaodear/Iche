package com.android.library.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by dugang on 2015/10/09. Activity父类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    /**
     * 跳转到指定的Activity
     */
    protected void skipToActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 带返回的跳转到指定Activity
     */
    protected void skipToActivityForResult(Class<?> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    /**
     * 显示Toast消息
     */
    protected void showTips(String msg) {
        showTips(msg, Toast.LENGTH_SHORT);
    }

    /**
     * 显示Toast消息
     */
    protected void showTips(String msg, int duration) {
        Toast.makeText(mContext, msg, duration).show();
    }

    /**
     * 获取SharedPreferences
     */
    protected SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    /**
     * 保存SharedPreferences，根据传入类型自动转换
     */
    protected void setSharedPreferences(String keyName, Object value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        if (value instanceof Boolean) {
            editor.putBoolean(keyName, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(keyName, (Integer) value);
        } else if (value instanceof String) {
            editor.putString(keyName, (String) value);
        } else if (value instanceof Float) {
            editor.putFloat(keyName, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(keyName, (Long) value);
        }
        editor.apply();
    }

    /**
     * 移除SharedPreferences
     */
    protected void removeSharedPreferences(String key) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 清空SharedPreferences
     */
    protected void clearSharedPreferences() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.apply();
    }
}
