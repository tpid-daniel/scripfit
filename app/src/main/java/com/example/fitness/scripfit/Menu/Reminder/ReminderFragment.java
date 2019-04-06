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
    ImageView iv_senin;
    boolean day2=false;
    ImageView iv_selasa;
    boolean day3=false;
    ImageView iv_rabu;
    boolean day4=false;
    ImageView iv_kamis;
    boolean day5=false;
    ImageView iv_jumat;
    boolean day6=false;
    ImageView iv_sabtu;
    boolean day7=false;
    ImageView iv_minggu;
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
        View rootView = inflater.inflate(R.layout.fragment_reminder, container, false);
        Button btn_addReminder = (Button) rootView.findViewById(R.id.btn_addReminder);
        Button btn_resetReminder = (Button) rootView.findViewById(R.id.btn_resetReminder);
        tv_clock = (TextView) rootView.findViewById(R.id.tv_clock);
        iv_senin =(ImageView) rootView.findViewById(R.id.iv_senin);
        iv_selasa=(ImageView) rootView.findViewById(R.id.iv_selasa);
        iv_rabu =(ImageView) rootView.findViewById(R.id.iv_rabu);
        iv_kamis =(ImageView) rootView.findViewById(R.id.iv_kamis);
        iv_jumat =(ImageView) rootView.findViewById(R.id.iv_jumat);
        iv_sabtu=(ImageView) rootView.findViewById(R.id.iv_sabtu);
        iv_minggu =(ImageView) rootView.findViewById(R.id.iv_minggu);
        once = (RadioButton) rootView.findViewById(R.id.rdi_once);
        repeat = (RadioButton) rootView.findViewById(R.id.rdi_repeat);

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
        iv_senin.setImageResource(R.drawable.ic_bell);
        iv_selasa.setImageResource(R.drawable.ic_bell);
        iv_rabu.setImageResource(R.drawable.ic_bell);
        iv_kamis.setImageResource(R.drawable.ic_bell);
        iv_jumat.setImageResource(R.drawable.ic_bell);
        iv_sabtu.setImageResource(R.drawable.ic_bell);
        iv_minggu.setImageResource(R.drawable.ic_bell);
        manager.cancel(pendingIntent);
        tv_clock.setText("00 : 00");
        if(preferences.getPrefJam() != null){
            preferences.savePrefReminder("", "", false, false, false, false, false, false, false);
        }
    }

    public void getCheckReminderPref(){
        if(preferences.getPrefJam() != null){
            tv_clock.setText(preferences.getPrefJam());
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

        if(preferences.getPrefSenin() != false){
            iv_senin.setImageResource(R.drawable.ic_bell_fill);
            day2=true;
        }
        if(preferences.getPrefSelasa() != false){
            iv_selasa.setImageResource(R.drawable.ic_bell_fill);
            day3=true;
        }
        if(preferences.getPrefRabu() != false){
            iv_rabu.setImageResource(R.drawable.ic_bell_fill);
            day4=true;
        }
        if(preferences.getPrefKamis() != false){
            iv_kamis.setImageResource(R.drawable.ic_bell_fill);
            day5=true;
        }
        if(preferences.getPrefJumat() != false){
            iv_jumat.setImageResource(R.drawable.ic_bell_fill);
            day6=true;
        }
        if(preferences.getPrefSabtu() != false){
            iv_sabtu.setImageResource(R.drawable.ic_bell_fill);
            day7=true;
        }
        if(preferences.getPrefMinggu() != false){
            iv_minggu.setImageResource(R.drawable.ic_bell_fill);
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
    }

    public void setDay(){
        if (tv_clock.getText().toString() == "") {
            tv_clock.setText("00 : 00");
        }
        tv_clock.setText("00 : 00");
        iv_senin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day2==false){
                    iv_senin.setImageResource(R.drawable.ic_bell_fill);
                    day2=true;
                }else {
                    iv_senin.setImageResource(R.drawable.ic_bell);
                    day2=false;
                }

            }
        });

        iv_selasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day3==false){
                    iv_selasa.setImageResource(R.drawable.ic_bell_fill);
                    day3=true;
                }else {
                    iv_selasa.setImageResource(R.drawable.ic_bell);
                    day3=false;
                }

            }
        });

        iv_rabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day4==false){
                    iv_rabu.setImageResource(R.drawable.ic_bell_fill);
                    day4=true;
                }else {
                    iv_rabu.setImageResource(R.drawable.ic_bell);
                    day4=false;
                }
            }
        });

        iv_kamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day5==false){
                    iv_kamis.setImageResource(R.drawable.ic_bell_fill);
                    day5=true;
                }else {
                    iv_kamis.setImageResource(R.drawable.ic_bell);
                    day5=false;
                }

            }
        });

        iv_jumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day6==false){
                    iv_jumat.setImageResource(R.drawable.ic_bell_fill);
                    day6=true;
                }else {
                    iv_jumat.setImageResource(R.drawable.ic_bell);
                    day6=false;
                }

            }
        });

        iv_sabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day7==false){
                    iv_sabtu.setImageResource(R.drawable.ic_bell_fill);
                    day7=true;
                }else {
                    iv_sabtu.setImageResource(R.drawable.ic_bell);
                    day7=false;
                }

            }
        });

        iv_minggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day1==false){
                    iv_minggu.setImageResource(R.drawable.ic_bell_fill);
                    day1=true;
                }else {
                    iv_minggu.setImageResource(R.drawable.ic_bell);
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
        timePickerDialog.setTitle("Choose hour:");
        timePickerDialog.show();
    }

    public void setReminder(){
        Toast.makeText(getContext(), "Pengingat berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        if(hour==0 || minuteTime==0 || myCalender.get(Calendar.DAY_OF_WEEK)==0){
            Toast.makeText(getContext(), "Isi semua data terlebih dahulu", Toast.LENGTH_SHORT).show();
        }else{
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
