package com.example.k2ohashi.testapp.Fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.k2ohashi.testapp.Activity.MainActivity;
import com.example.k2ohashi.testapp.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.regex.Matcher;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener{

    private EditText editText;
    private FragmentCallBackListener mListener;


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

        editText = (EditText) getActivity().findViewById(R.id.main_edit_text);
        editText.setOnClickListener(this);
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
                        String newValue = value.replace("日本, ", "");
                        String regex = "〒[0-9]+-[0-9]+ ";
                        newValue = newValue.replaceAll(regex, Matcher.quoteReplacement(""));

                        Log.i("Fragment :","1 : "+newValue);
                        place.getLatLng();

                        Log.i("Fragment :","2 : "+String.valueOf(place.getLatLng().latitude));
                        Log.i("Fragment :","3 : "+String.valueOf(place.getLatLng().longitude));

                    }catch (Exception ignored){}
                }
                break;
            default:
                break;
        }
    }
}
