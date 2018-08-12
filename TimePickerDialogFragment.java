package com.example.m0z.alarmclock;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDialogFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // 1 : Context
        // 2 : TimePickerDialog.OnTimeSetListener(下にあるメソッドの事かと)
        // 3 : 時
        // 4 : 分
        // 5 : 24時間表記にするかどうか
        TimePickerDialog timePickerDialog =
                new TimePickerDialog(getActivity(), this, hour, minute, true);

        return timePickerDialog;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // 時刻が選択されたときの対処
    }
}
