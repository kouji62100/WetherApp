package com.example.k2ohashi.testapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.k2ohashi.testapp.Model.AlarmModel;
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

        if(alarmList.get(position).getTime() != null){
            ((TextView)convertView.findViewById(R.id.alarmTime)).setVisibility(View.VISIBLE);
            ((TextView)convertView.findViewById(R.id.alarmTime)).setText(alarmList.get(position).getTime());
        }else{
            ((TextView)convertView.findViewById(R.id.alarmTime)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getSunday()){
            ((Button)convertView.findViewById(R.id.SU)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.SU)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getMonday()){
            ((Button)convertView.findViewById(R.id.MO)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.MO)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getTuesday()){
            ((Button)convertView.findViewById(R.id.TU)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.TU)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getWednesday()){
            ((Button)convertView.findViewById(R.id.WE)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.WE)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getThersday()){
            ((Button)convertView.findViewById(R.id.TH)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.TH)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getFriday()){
            ((Button)convertView.findViewById(R.id.FR)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.FR)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getSataday()){
            ((Button)convertView.findViewById(R.id.SA)).setVisibility(View.VISIBLE);
        }else{
            ((Button)convertView.findViewById(R.id.SA)).setVisibility(View.GONE);
        }

        if(alarmList.get(position).getAlarmSwitch()){
            ((Switch)convertView.findViewById(R.id.alarmSwitch)).setVisibility(View.VISIBLE);
        }else{
            ((Switch)convertView.findViewById(R.id.alarmSwitch)).setVisibility(View.GONE);
        }


        return convertView;
    }
}
