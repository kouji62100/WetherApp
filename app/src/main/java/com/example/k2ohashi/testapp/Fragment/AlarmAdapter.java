package com.example.k2ohashi.testapp.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.k2ohashi.testapp.R;

import java.util.ArrayList;

/**
 * Created by k2ohashi on 17/05/12.
 */
public class AlarmAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<AlarmModel> alarmList;

    public AlarmAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setAlarmList(ArrayList<AlarmModel> alarmList) {
        this.alarmList = alarmList;
    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public Object getItem(int position) {
        return alarmList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alarmList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.alarm_list,parent,false);

//        ((TextView)convertView.findViewById(R.id.name)).setText(tweetList.get(position).getName());
//        ((TextView)convertView.findViewById(R.id.tweet)).setText(tweetList.get(position).getTweet());

        return convertView;
    }
}
