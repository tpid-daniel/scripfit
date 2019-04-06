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
    String KEY_JAM = "jam";
    String KEY_STATUS = "status";
    String KEY_SENIN = "senin";
    String KEY_SELASA = "selasa";
    String KEY_RABU = "rabu";
    String KEY_KAMIS = "kamis";
    String KEY_JUMAT = "jumat";
    String KEY_SABTU = "sabtu";
    String KEY_MINGGU = "minggu";

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

    public void savePrefReminder(String jam, String status, boolean senin, boolean selasa, boolean rabu, boolean kamis, boolean jumat, boolean sabtu, boolean minggu){
        editor.putString(KEY_JAM, jam);
        editor.putString(KEY_STATUS, status);
        editor.putBoolean(KEY_SENIN, senin);
        editor.putBoolean(KEY_SELASA, selasa);
        editor.putBoolean(KEY_RABU, rabu);
        editor.putBoolean(KEY_KAMIS, kamis);
        editor.putBoolean(KEY_JUMAT, jumat);
        editor.putBoolean(KEY_SABTU, sabtu);
        editor.putBoolean(KEY_MINGGU, minggu);
        editor.commit();
    }

    public String getPrefJam(){
        return pref.getString(KEY_JAM, null);
    }
    public String getPrefStatus(){
        return pref.getString(KEY_STATUS, null);
    }
    public Boolean getPrefSenin(){
        return pref.getBoolean(KEY_SENIN, false);
    }
    public Boolean getPrefSelasa(){
        return pref.getBoolean(KEY_SELASA, false);
    }
    public Boolean getPrefRabu(){
        return pref.getBoolean(KEY_RABU, false);
    }
    public Boolean getPrefKamis(){
        return pref.getBoolean(KEY_KAMIS, false);
    }
    public Boolean getPrefJumat(){
        return pref.getBoolean(KEY_JUMAT, false);
    }
    public Boolean getPrefSabtu(){
        return pref.getBoolean(KEY_SABTU, false);
    }
    public Boolean getPrefMinggu(){
        return pref.getBoolean(KEY_MINGGU, false);
    }


    public void clearPref(){
        editor.clear();
        editor.commit();
    }
}
