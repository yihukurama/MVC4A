package com.yihukurama.mvc4a.Model.access;

import android.content.Context;
import android.content.SharedPreferences;

import com.yihukurama.mvc4a.Mvc4aApplication;

/**
 * Created by dengshuai on 16/1/5.
 */
public class SharePreference {
    private static SharePreference sharePreference;

    private SharedPreferences preferences;

    private SharePreference() {
        preferences = Mvc4aApplication.getInstance().getSharedPreferences("MVC4A_PREFENCE", Context.MODE_PRIVATE);
    }

    public static SharePreference getInstance() {
        if (sharePreference == null)
            sharePreference = new SharePreference();
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
}
