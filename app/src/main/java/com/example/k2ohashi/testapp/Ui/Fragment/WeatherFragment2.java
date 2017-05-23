package com.example.k2ohashi.testapp.Ui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k2ohashi.testapp.Ui.Activity.MainActivity;
import com.example.k2ohashi.testapp.R;

/**
 * Created by k2ohashi on 17/05/23.
 */
public class WeatherFragment2 extends Fragment {
    public static final String TAG = "WeatherFragment2";  // Fragment識別用タグ

    private FragmentCallBackListener mListener;

    public WeatherFragment2() {
    }

    public static WeatherFragment2 newInstance(){
        WeatherFragment2 fragment = new WeatherFragment2();
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
        return inflater.inflate(R.layout.fragment_weather2, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }
}