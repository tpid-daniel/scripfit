package com.example.fitness.scripfit.Menu.Reminder;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fitness.scripfit.Preferences;
import com.example.fitness.scripfit.R;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReminderFragment extends Fragment {
    final Calendar myCalender = Calendar.getInstance();
    int hour = 0;
    int minuteTime = 0;
    TextView tv_clock;
    ImageView iv_clockReminder;
    TextView tv_waktuReminder;
    CheckBox cb_senin;
    boolean day2=false;
    CheckBox cb_selasa;
    boolean day3=false;
    CheckBox cb_rabu;
    boolean day4=false;
    CheckBox cb_kamis;
    boolean day5=false;
    CheckBox cb_jumat;
    boolean day6=false;
    CheckBox cb_sabtu;
    boolean day7=false;
    CheckBox cb_minggu;
    boolean day1=false;
    AlarmManager manager;
    Intent myIntent;
    PendingIntent pendingIntent;
    RadioButton once,repeat;
    Preferences preferences;

    public ReminderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //view untuk inisialisasi findviewbyid dari layout frag reminder
        View rootView = inflater.inflate(R.layout.fragment_reminder, container, false);
        Button btn_addReminder = (Button) rootView.findViewById(R.id.btn_addReminder);
        Button btn_resetReminder = (Button) rootView.findViewById(R.id.btn_resetReminder);
        tv_clock = (TextView) rootView.findViewById(R.id.tv_clock);
        cb_senin =(CheckBox) rootView.findViewById(R.id.cb_senin);
        cb_selasa=(CheckBox) rootView.findViewById(R.id.cb_selasa);
        cb_rabu =(CheckBox) rootView.findViewById(R.id.cb_rabu);
        cb_kamis =(CheckBox) rootView.findViewById(R.id.cb_kamis);
        cb_jumat =(CheckBox) rootView.findViewById(R.id.cb_jumat);
        cb_sabtu=(CheckBox) rootView.findViewById(R.id.cb_sabtu);
        cb_minggu =(CheckBox) rootView.findViewById(R.id.cb_minggu);
        once = (RadioButton) rootView.findViewById(R.id.rdi_once);
        repeat = (RadioButton) rootView.findViewById(R.id.rdi_repeat);
        iv_clockReminder = (ImageView) rootView.findViewById(R.id.iv_clockReminder);
        tv_waktuReminder = (TextView) rootView.findViewById(R.id.tv_waktuReminder);
        manager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

        myIntent = new Intent(getActivity(),AlarmNotificationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(getContext(),0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);
        tv_clock.setText("00 : 00");

        btn_addReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReminder();
            }
        });
        btn_resetReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetReminder();
            }
        });
        tv_clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHourPicker();
            }
        });
        iv_clockReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHourPicker();
            }
        });
        tv_waktuReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHourPicker();
            }
        });
        setDay();
        preferences = new Preferences(getContext());
        getCheckReminderPref();
        return rootView;

    }

    public void resetReminder(){
        Toast.makeText(getContext(), "Pengingat berhasil di hapus", Toast.LENGTH_SHORT).show();
        day1=false;
        day2=false;
        day3=false;
        day4=false;
        day5=false;
        day6=false;
        day7=false;
        cb_senin.setChecked(false);
        cb_selasa.setChecked(false);
        cb_rabu.setChecked(false);
        cb_kamis.setChecked(false);
        cb_jumat.setChecked(false);
        cb_sabtu.setChecked(false);
        cb_minggu.setChecked(false);
        manager.cancel(pendingIntent);
        tv_clock.setText("00 : 00");
        if(preferences.getPrefJam() != null){
            preferences.savePrefReminder("", "once", false, false, false, false, false, false, false);
        }
        hour =0;
        minuteTime=0;
    }

    public void getCheckReminderPref(){
        if(preferences.getPrefJam() != null){
            if (preferences.getPrefJam() == ""){
                tv_clock.setText("00 : 00");
            }else{
                tv_clock.setText(preferences.getPrefJam());
            }
        }
        else{
            tv_clock.setText("00 : 00");
        }

        if(preferences.getPrefStatus() != null){
            if(preferences.getPrefStatus().contains("once")){
                once.setChecked(true);
                repeat.setChecked(false);
            }
            else {
                once.setChecked(false);
                repeat.setChecked(true);
            }
        }

        if(preferences.getPrefSenin()){
            cb_senin.setChecked(true);
            day2=true;
        }
        if(preferences.getPrefSelasa()){
            cb_selasa.setChecked(true);
            day3=true;
        }
        if(preferences.getPrefRabu()){
            cb_rabu.setChecked(true);
            day4=true;
        }
        if(preferences.getPrefKamis()){
            cb_kamis.setChecked(true);
            day5=true;
        }
        if(preferences.getPrefJumat()){
            cb_jumat.setChecked(true);
            day6=true;
        }
        if(preferences.getPrefSabtu()){
            cb_sabtu.setChecked(true);
            day7=true;
        }
        if(preferences.getPrefMinggu()){
            cb_minggu.setChecked(true);
            day1=true;
        }
        if(day2){
            myCalender.set(Calendar.DAY_OF_WEEK, 2);
        }
        else if(day3){
            myCalender.set(Calendar.DAY_OF_WEEK, 3);
        }
        else if(day4){
            myCalender.set(Calendar.DAY_OF_WEEK, 4);
        }
        else if(day5){
            myCalender.set(Calendar.DAY_OF_WEEK, 5);
        }
        else if(day6){
            myCalender.set(Calendar.DAY_OF_WEEK, 6);
        }
        else if(day7){
            myCalender.set(Calendar.DAY_OF_WEEK, 7);
        }
        else if(day1){
            myCalender.set(Calendar.DAY_OF_WEEK, 1);
        }

        Log.i("day 2", String.valueOf(day2));
    }

    public void setDay(){
        if (tv_clock.getText().toString() == "") {
            tv_clock.setText("00 : 00");
        }
        tv_clock.setText("00 : 00");
        cb_senin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_senin.isChecked()){
                    day2=true;
                }else {
                    day2=false;
                }
            }
        });

        cb_selasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_selasa.isChecked()){
                    day3=true;
                }else {
                    day3=false;
                }
            }
        });

        cb_rabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_rabu.isChecked()){
                    day4=true;
                }else {
                    day4=false;
                }
            }
        });

        cb_kamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_kamis.isChecked()){
                    day5=true;
                }else {
                    day5=false;
                }
            }
        });

        cb_jumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_jumat.isChecked()){
                    day6=true;
                }else {
                    day6=false;
                }
            }
        });

        cb_sabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_sabtu.isChecked()){
                    day7=true;
                }else {
                    day7=false;
                }
            }
        });

        cb_minggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_minggu.isChecked()){
                    day1=true;
                }else {
                    day1=false;
                }
            }
        });


    }

    public void showHourPicker() {
        hour = myCalender.get(Calendar.HOUR_OF_DAY);
        minuteTime = myCalender.get(Calendar.MINUTE);
        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (view.isShown()) {
                    myCalender.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    myCalender.set(Calendar.MINUTE, minute);
                    hour = myCalender.get(Calendar.HOUR_OF_DAY);
                    minuteTime = myCalender.get(Calendar.MINUTE);
                    tv_clock.setText(hour + " : " + minuteTime);
                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), R.style.DatePickerTheme, myTimeListener, hour, minuteTime, true);
        timePickerDialog.setTitle("Pilih waktu:");
        timePickerDialog.show();
    }

    public void setReminder(){
        if(hour==0 || minuteTime==0 && day1 == false && day2 == false && day3 == false && day4 == false && day5 == false && day6 == false && day7 == false){
            Toast.makeText(getContext(), "Isi semua data terlebih dahulu", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "Pengingat berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            if(day2==true){
                myCalender.set(Calendar.DAY_OF_WEEK, 2);
            }
            else if(day3){
                myCalender.set(Calendar.DAY_OF_WEEK, 3);
            }
            else if(day4){
                myCalender.set(Calendar.DAY_OF_WEEK, 4);
            }
            else if(day5){
                myCalender.set(Calendar.DAY_OF_WEEK, 5);
            }
            else if(day6){
                myCalender.set(Calendar.DAY_OF_WEEK, 6);
            }
            else if(day7){
                myCalender.set(Calendar.DAY_OF_WEEK, 7);
            }
            else if(day1){
                myCalender.set(Calendar.DAY_OF_WEEK, 1);
            }

            if(once.isChecked()){
                manager.set(AlarmManager.RTC_WAKEUP, myCalender.getTimeInMillis(),pendingIntent);
                preferences.savePrefReminder(tv_clock.getText().toString(), "once", day2, day3, day4, day5, day6, day7, day1);
            }
            else if(repeat.isChecked()){
                manager.setRepeating(AlarmManager.RTC_WAKEUP, myCalender.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                preferences.savePrefReminder(tv_clock.getText().toString(), "repeat", day2, day3, day4, day5, day6, day7, day1);
            }
        }
    }
}
