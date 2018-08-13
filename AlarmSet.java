package com.example.m0z.alarmclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;

public class AlarmSet extends AppCompatActivity{

    //xml上のTimePicker
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_set);

        //とりあえず時間は24時間表記にしとこ
        timePicker = findViewById(R.id.setTimePicker);
        timePicker.setIs24HourView(true);
    }
}
