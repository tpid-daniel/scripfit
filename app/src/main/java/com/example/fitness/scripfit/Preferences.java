package com.example.fitness.scripfit;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    String PREF_STATUS = "DATA";
    String KEY_RENCANA = "rencana";

    public Preferences(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_STATUS, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void savePref(String value){
        editor.putString(KEY_RENCANA, value);
        editor.commit();
    }

    public String getPref(){
        return pref.getString(KEY_RENCANA, null);
    }

    public void clearPref(){
        editor.clear();
        editor.commit();
    }
}
