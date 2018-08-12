package com.example.m0z.alarmclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TimePickerDialogFragment timeFragment;
    ListView listView;
    List<ListItem> data;
    ListItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.alarmList);
        data = new ArrayList<ListItem>();
        AlarmListAdapter lad = new AlarmListAdapter(this, R.id.txtTime, data);
        listView.setAdapter(lad);

        String strAlarm = getAlarm("08:00");
        data.add(item);

    }

    private String getAlarm(String alarm){
        item = new ListItem();
        item.setData(alarm);

        return alarm;
    }

    /**
     * メニューバーにアイコンを設置する
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        return true;
    }

    /**
     * メニューアイコンがクリックされたときの処理
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.createAlarm:
                TimePickerDialogFragment timePicker = new TimePickerDialogFragment();
                timePicker.show(getFragmentManager(), "timePicker");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
