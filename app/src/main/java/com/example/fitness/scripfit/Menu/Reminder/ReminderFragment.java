package com.example.fitness.scripfit.Menu.Reminder;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

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

    public ReminderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_reminder, container, false);
        Button btn_addReminder = (Button) rootView.findViewById(R.id.btn_addReminder);

        btn_addReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setalarm();
            }
        });
        return rootView;


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
                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), R.style.DatePickerTheme, myTimeListener, hour, minuteTime, true);
        timePickerDialog.setTitle("Choose hour:");
        timePickerDialog.show();
    }

    private void setalarm() {

        Calendar cal=Calendar.getInstance();
        // cal.set(Calendar.MONTH,6);
        // cal.set(Calendar.YEAR,2013);
        // cal.set(Calendar.DAY_OF_MONTH,12);
        cal.set(Calendar.HOUR_OF_DAY,13);
        cal.set(Calendar.MINUTE,11);
        Intent intent = new Intent(getActivity(), Notification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 1253, intent, PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);

        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent );
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        Toast.makeText(getActivity(), "Alarm SET.", Toast.LENGTH_LONG).show();
    }

}
