package com.example.daniel.shoplogin.util;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference  {
    private final static String MY_PREF = "MY_PREF";

    private final static String IS_AUTO_LOGIN_CHECKED = "checkAutoLogin";


    public static boolean putAutoLoginValue(Context context, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_AUTO_LOGIN_CHECKED, value);

        return editor.commit();

    }

    public static Boolean getAutoLoginValue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF, 0);
        return sharedPreferences.getBoolean(IS_AUTO_LOGIN_CHECKED, false);
    }



}
