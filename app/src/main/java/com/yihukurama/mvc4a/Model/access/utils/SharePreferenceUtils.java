package com.yihukurama.mvc4a.model.access.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.yihukurama.mvc4a.Mvc4aApplication;
import com.yihukurama.mvc4a.model.data.memory.StringConstants;

/**
 * Created by dengshuai on 16/1/5.
 * 轻量级持久化缓存，存在于sdcard中的APP私有文件夹里
 */
public class SharePreferenceUtils {
    private static SharePreferenceUtils sharePreference;

    private SharedPreferences preferences;

    private SharePreferenceUtils() {
        preferences = Mvc4aApplication.getInstance().getSharedPreferences(StringConstants.SHARE_PRE_NAME, Context.MODE_PRIVATE);
    }

    public static SharePreferenceUtils getInstance() {
        if (sharePreference == null)
            sharePreference = new SharePreferenceUtils();
        return sharePreference;
    }

    public void saveInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public void saveIString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }
}
