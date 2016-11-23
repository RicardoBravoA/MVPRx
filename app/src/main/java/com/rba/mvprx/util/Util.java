package com.rba.mvprx.util;

import android.util.Log;
import android.util.Patterns;

import com.google.gson.Gson;
import com.rba.mvprx.model.response.ErrorResponse;

import java.util.regex.Pattern;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class Util {
    public static boolean validEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static boolean isError(String json){
        try{
            ErrorResponse errorResponse = new Gson().fromJson(json, ErrorResponse.class);
            Log.i("z- onResponse", new Gson().toJson(errorResponse));
            Log.i("z- getStatus", " - "+errorResponse.getStatus());
            if(errorResponse.getStatus() == null){
                return false;
            }else{
                return  true;
            }
        }catch (ClassCastException e){
            e.printStackTrace();
        }

        return false;
    }


}
