package com.example.k2ohashi.testapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.k2ohashi.testapp.WeatherApp;
import com.example.k2ohashi.testapp.WeatherDataRequest;
import com.example.k2ohashi.testapp.databese.RealmHelper;
import com.example.k2ohashi.testapp.model.WeatherDataEntity;
import com.example.k2ohashi.testapp.ui.activity.MainActivity;
import com.example.k2ohashi.testapp.R;

/**
 * Created by k2ohashi on 17/05/23.
 */
public class WeatherFragment4 extends Fragment {
    public static final String TAG = "WeatherFragment4";  // Fragment識別用タグ

    private FragmentCallBackListener mListener;
    private RealmHelper helper;

    public WeatherFragment4() {
    }

    public static WeatherFragment4 newInstance(){
        WeatherFragment4 fragment = new WeatherFragment4();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (MainActivity)context;
        helper = new RealmHelper(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather4, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        WeatherApp.get()
                .getRequestQueue()
                .add(WeatherDataRequest.get(helper.getAreaData().get(3).getLat(), helper.getAreaData().get(3).getLon(),new WeatherDataRequest.WeatherDataRequestResponseListener(){
                    @Override
                    public void onResponse(WeatherDataEntity response){
                        //Viewの表示処理
                        TextView area_name1 = (TextView)getActivity().findViewById(R.id.area_name1);
                        area_name1.setText(helper.getAreaData().get(3).getAreaName());
                    }
                },new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError response){

                    }
                }));
    }
}
