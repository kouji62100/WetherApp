package com.example.k2ohashi.testapp.Ui.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.k2ohashi.testapp.Model.WeatherModel;
import com.example.k2ohashi.testapp.Ui.Activity.MainActivity;
import com.example.k2ohashi.testapp.Adapter.AreaAdapter;
import com.example.k2ohashi.testapp.Databese.RealmHelper;
import com.example.k2ohashi.testapp.OnRecyclerListener;
import com.example.k2ohashi.testapp.R;
import com.example.k2ohashi.testapp.WeatherApp;
import com.example.k2ohashi.testapp.Model.WeatherEntity;
import com.example.k2ohashi.testapp.WeatherRequest;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener, OnRecyclerListener, WeatherRequest.WeatherRequestResponseListener,Response.ErrorListener{
    public static final String TAG = "DetailFragment";  // Fragment識別用タグ

    private FragmentCallBackListener mListener;

    private RecyclerView mRecyclerView = null;
    private AreaAdapter mAdapter = null;
    private RealmHelper helper;
    private ArrayList<WeatherModel> weatherList;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(){
        DetailFragment fragment = new DetailFragment();
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
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);

        FloatingActionButton button = (FloatingActionButton)getActivity().findViewById(R.id.area_fab);
        button.setOnClickListener(this);


        // RecyclerViewの参照を取得
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.area_listView);
        // レイアウトマネージャを設定(ここで縦方向の標準リストであることを指定)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        reloadView();

        mAdapter = new AreaAdapter(getContext(),weatherList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        try {
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(new AutocompleteFilter.Builder().setCountry("JP").build())
                            .build(getActivity());
            startActivityForResult(intent, 1);
        } catch (GooglePlayServicesRepairableException e) {
            GooglePlayServicesUtil
                    .showErrorDialogFragment(e.getConnectionStatusCode(), getActivity(), null, 0, null);
        } catch (GooglePlayServicesNotAvailableException e) {
            // 例外を処理
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                } else {
                    // Get the user's selected place from the Intent.
                    try {
                        Place place = PlaceAutocomplete.getPlace(getContext(), data);

                        String value = place.getAddress() + " " + place.getName();
                        //'日本,' と '〒@@@-@@@@' を削除する
                        String areaName = value.replace("日本, ", "");
                        String regex = "〒[0-9]+-[0-9]+ ";
                        areaName = areaName.replaceAll(regex, Matcher.quoteReplacement(""));

                        //地域名，緯度，軽度を保存
                        helper.writteAreaDB(areaName,String.valueOf(place.getLatLng().latitude),String.valueOf(place.getLatLng().longitude));

                        reloadView();

                    }catch (Exception ignored){}
                }
                break;
            default:
                break;
        }
    }

    public void reloadView(){

        weatherList = new ArrayList<>();

        if(helper.getAreaData() == null){
            return;
        }

        for(int i = 0; i < helper.getAreaData().size(); i++){

            final WeatherModel model = new WeatherModel();

            model.setAreaName(helper.getAreaData().get(i).getAreaName());

            WeatherApp.get()
                    .getRequestQueue()
                    .add(WeatherRequest.get(helper.getAreaData().get(i).getLat(),helper.getAreaData().get(i).getLon(),new WeatherRequest.WeatherRequestResponseListener(){
                        @Override
                        public void onResponse(WeatherEntity response){
                            model.setWeather("雨");
                            model.setTemp("30℃");
                        }
                    },new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError response){

                            Log.i("onErrorResponse : ",""+response);
                        }
                    }));

            weatherList.add(model);
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRecyclerClicked(View v, int position) {
        // セルクリック処理
    }

    @Override
    public void onResponse(WeatherEntity response){

    }

    @Override
    public void onErrorResponse(VolleyError response){

        Log.i("onErrorResponse : ",""+response);
    }
}
