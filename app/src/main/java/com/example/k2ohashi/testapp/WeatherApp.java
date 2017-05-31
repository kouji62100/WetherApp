package com.example.k2ohashi.testapp;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by k2ohashi on 17/05/19.
 */
public class WeatherApp extends Application{

    // インスタンス
    private static WeatherApp sInstance = null;

    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    /**
     * get
     *
     * @return WeatherApp
     */
    public static WeatherApp get() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this);
        }
        return requestQueue;
    }

    public ImageLoader getImageLoader() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader(getRequestQueue(), new ImageLruCache());
        }
        return imageLoader;
    }
}
