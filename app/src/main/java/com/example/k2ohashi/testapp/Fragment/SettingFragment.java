package com.example.k2ohashi.testapp.Fragment;


import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.k2ohashi.testapp.Activity.AlarmCreateActivity;
import com.example.k2ohashi.testapp.Activity.ReceivedActivity;
import com.example.k2ohashi.testapp.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {


    public SettingFragment() {
    }

    public static SettingFragment newInstance(){
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);

        FloatingActionButton button = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        button.setOnClickListener(this);

        ListView listView = (ListView) getActivity().findViewById(R.id.listView);

        ArrayList<AlarmModel> list = new ArrayList<>();

        AlarmModel model1 = new AlarmModel();
        model1.setId(12892012);
        list.add(model1);

        AlarmModel model2 = new AlarmModel();
        model2.setId(12892012);
        list.add(model2);

        AlarmModel model3 = new AlarmModel();
        model3.setId(12892012);
        list.add(model3);

        AlarmModel model4 = new AlarmModel();
        model4.setId(12892012);
        list.add(model4);

        AlarmModel model5 = new AlarmModel();
        model5.setId(12892012);
        list.add(model5);

        AlarmModel model6 = new AlarmModel();
        model6.setId(12892012);
        list.add(model6);

        AlarmModel model7 = new AlarmModel();
        model7.setId(12892012);
        list.add(model7);

        AlarmAdapter adapter = new AlarmAdapter(getContext());
        adapter.setAlarmList(list);
        listView.setAdapter(adapter);

//        Intent i = new Intent(getContext(), ReceivedActivity.class); // ReceivedActivityを呼び出すインテントを作成
//        PendingIntent sender = PendingIntent.getBroadcast(getContext(), 0, i, 0); // ブロードキャストを投げるPendingIntentの作成
//
//        Calendar calendar = Calendar.getInstance(); // Calendar取得
//        calendar.setTimeInMillis(System.currentTimeMillis()); // 現在時刻を取得
//        calendar.add(Calendar.SECOND, 15); // 現時刻より15秒後を設定
//
//        Calendar c = Calendar.getInstance();
//        c.setTimeInMillis(0);
//        c.set(Calendar.YEAR, 2015);
//        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
//        c.set(Calendar.DAY_OF_MONTH, 6);
//        c.set(Calendar.HOUR_OF_DAY, 7);
//        c.set(Calendar.MINUTE, 0);
//        c.set(Calendar.SECOND, 0);
//
//        AlarmManager am = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE); // AlramManager取得
//        am.setRepeating(AlarmManager.RTC,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,sender);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                Intent createActivity = new Intent(getActivity(), AlarmCreateActivity.class);

                ActivityOptions option = ActivityOptions.makeSceneTransitionAnimation(getActivity(),v,getString(R.string.title_activity_alarm_create));

                break;
        }
    }

}
