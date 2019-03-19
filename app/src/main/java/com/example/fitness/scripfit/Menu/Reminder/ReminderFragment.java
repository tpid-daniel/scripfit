package com.example.fitness.scripfit.Menu.Reminder;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.fitness.scripfit.R;

import java.util.Calendar;

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
                showHourPicker();
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

}
