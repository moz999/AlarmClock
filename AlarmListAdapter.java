package com.example.m0z.alarmclock;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AlarmListAdapter extends ArrayAdapter<ListItem> {

    private LayoutInflater inflater;
    private ListItem items;

    /**
     *  コンストラクタ
     * @param context　MainActivityが受け取るので、Main~上で「this」をかく
     * @param resource　xmlファイル内で表示したい部分のid
     * @param objects　データ
     */
    public AlarmListAdapter(Context context, int resource, List<ListItem> objects){
        super(context, resource, objects);

        //他のxmlファイルを取得するための準備
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 実質的な処置はここで！
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            //ListViewの各行のレイアウトを設定
            convertView = inflater.inflate(R.layout.alarm_list, null, false);
        }

        //リストのアイテムデータを取得
        items = this.getItem(position);

        TextView textView = (TextView)convertView.findViewById(R.id.txtTime);
        if(textView != null){
            textView.setText(items.getData());
        }

        return convertView;
    }
}
