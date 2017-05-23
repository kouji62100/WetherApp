package com.example.k2ohashi.testapp.Ui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.k2ohashi.testapp.Ui.Activity.MainActivity;
import com.example.k2ohashi.testapp.R;
import com.example.k2ohashi.testapp.WeatherApp;
import com.example.k2ohashi.testapp.Model.WeatherEntity;
import com.example.k2ohashi.testapp.WeatherRequest;

public class HomeFragment extends Fragment implements WeatherRequest.WeatherRequestResponseListener,Response.ErrorListener{

    private FragmentCallBackListener mListener;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        WeatherApp.get().getRequestQueue().add(WeatherRequest.get("35.0608029","136.12453499999998",this,this));
    }

    @Override
    public void onResponse(WeatherEntity response){
        Log.i("onResponse : ",""+response.list.get(0).weather.get(0).description);
        Log.i("onResponse : ",""+response.city.name);
        TextView weather = (TextView)getActivity().findViewById(R.id.weather_text);
        weather.setText(response.list.get(0).weather.get(0).description);
    }

    @Override
    public void onErrorResponse(VolleyError response){

        Log.i("onErrorResponse : ",""+response);
    }
}
