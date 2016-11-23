package com.rba.mvprx.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rba.mvprx.model.response.LoginResponse;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */

public class SessionManager {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String KEY_DATA = "data";
    private static final String PREF_NAME = "MVP_PROJECT";

    private static void initSessionManager(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        editor = sharedPreferences.edit();
    }

    public static void addSession(Context context, LoginResponse.DataEntity loginResponse) {
        initSessionManager(context);
        editor.putString(KEY_DATA, new Gson().toJson(loginResponse));
        editor.commit();
    }

    public static boolean isSession(Context context) {
        initSessionManager(context);
        return sharedPreferences.getString(KEY_DATA, "").length()>0;
    }

    public static void clear(Context context) {
        initSessionManager(context);
        editor.clear();
        editor.commit();
    }
}
