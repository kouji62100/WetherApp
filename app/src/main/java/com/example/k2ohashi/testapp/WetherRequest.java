package com.example.k2ohashi.testapp;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by k2ohashi on 17/05/19.
 */
public class WetherRequest extends Request {

    private final Response.Listener mListener;
    private final HashMap<String, String> mParams;

    public WetherRequest(String lat, String lon, String requestTag, Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.GET, AppConstants.BASE_URL, errorListener);
        mListener = listener;
        mParams = new HashMap<String, String>();
        mParams.put("lat", lat);
        mParams.put("lon", lon);
        mParams.put("cnt", "1");
        mParams.put("APPID", AppConstants.APP_ID);
        setTag(requestTag);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse networkResponse) {
        String resp = new String(networkResponse.data);
        JSONObject resultJson;
        try {
            resultJson = new JSONObject(resp);
        } catch (Exception e) {
            return null;
        }
        return Response.success(resultJson, getCacheEntry());
    }

    @Override
    protected void deliverResponse(Object response) {
        mListener.onResponse(response);
    }

}
