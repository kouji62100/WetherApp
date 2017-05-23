package com.example.k2ohashi.testapp.Ui.Fragment;


import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.k2ohashi.testapp.Ui.Activity.AlarmCreateActivity;
import com.example.k2ohashi.testapp.Ui.Activity.MainActivity;
import com.example.k2ohashi.testapp.Adapter.AlarmAdapter;
import com.example.k2ohashi.testapp.Model.AlarmModel;
import com.example.k2ohashi.testapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = "SettingFragment";  // Fragment識別用タグ

    private FragmentCallBackListener mListener;

    public SettingFragment() {
    }

    public static SettingFragment newInstance(){
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (MainActivity)context;
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
        model1.setTime("09:00");
        model1.setSunday(true);
        model1.setMonday(true);
        model1.setTuesday(true);
        model1.setWednesday(true);
        model1.setThersday(true);
        model1.setFriday(true);
        model1.setSataday(true);
        model1.setAlarmSwitch(true);
        list.add(model1);

        AlarmModel model2 = new AlarmModel();
        model2.setId(12892012);
        model2.setTime("09:00");
        model2.setSunday(true);
        model2.setMonday(true);
        model2.setTuesday(true);
        model2.setWednesday(true);
        model2.setThersday(true);
        model2.setFriday(true);
        model2.setSataday(true);
        model2.setAlarmSwitch(true);
        list.add(model2);

        AlarmModel model3 = new AlarmModel();
        model3.setId(12892012);
        model3.setTime("09:00");
        model3.setSunday(true);
        model3.setMonday(true);
        model3.setTuesday(true);
        model3.setWednesday(true);
        model3.setThersday(true);
        model3.setFriday(true);
        model3.setSataday(true);
        model3.setAlarmSwitch(true);
        list.add(model3);

        AlarmModel model4 = new AlarmModel();
        model4.setId(12892012);
        model4.setTime("09:00");
        model4.setSunday(true);
        model4.setMonday(true);
        model4.setTuesday(true);
        model4.setWednesday(true);
        model4.setThersday(true);
        model4.setFriday(true);
        model4.setSataday(true);
        model4.setAlarmSwitch(true);
        list.add(model4);

        AlarmModel model5 = new AlarmModel();
        model5.setId(12892012);
        model5.setTime("09:00");
        model5.setSunday(true);
        model5.setMonday(true);
        model5.setTuesday(true);
        model5.setWednesday(true);
        model5.setThersday(true);
        model5.setFriday(true);
        model5.setSataday(true);
        model5.setAlarmSwitch(true);
        list.add(model5);

        AlarmModel model6 = new AlarmModel();
        model6.setId(12892012);
        model6.setTime("09:00");
        model6.setSunday(true);
        model6.setMonday(true);
        model6.setTuesday(true);
        model6.setWednesday(true);
        model6.setThersday(true);
        model6.setFriday(true);
        model6.setSataday(true);
        model6.setAlarmSwitch(true);
        list.add(model6);

        AlarmModel model7 = new AlarmModel();
        model7.setId(12892012);
        model7.setTime(null);
        model7.setSunday(false);
        model7.setMonday(false);
        model7.setTuesday(false);
        model7.setWednesday(false);
        model7.setThersday(false);
        model7.setFriday(false);
        model7.setSataday(false);
        model7.setAlarmSwitch(false);
        list.add(model7);

//        AlarmModel model7 = new AlarmModel();
//        model7.setId(12892012);
//        list.add(model7);

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
