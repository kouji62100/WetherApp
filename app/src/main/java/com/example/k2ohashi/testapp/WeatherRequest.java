package com.example.k2ohashi.testapp;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.k2ohashi.testapp.Model.WeatherEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by k2ohashi on 17/05/19.
 */
public class WeatherRequest extends Request<WeatherEntity> {


    private final Gson gson = new Gson();
    private final Class<WeatherEntity> clazz;
    private final WeatherRequestResponseListener listener;
    private HashMap<String, String> params = new HashMap<>();

    /**
     * 独自データ型のレスポンスリスナーを実装
     */
    public interface WeatherRequestResponseListener {
        void onResponse(WeatherEntity response);
    }

    /**
     * リクエストのインスタンス取得
     *
     * @param listener      レスポンスリスナー
     * @param errorListener エラーリスナー
     * @return リクエストのインスタンス
     */
    public static WeatherRequest get(String lat, String lon, WeatherRequestResponseListener listener,Response.ErrorListener errorListener) {
        return new WeatherRequest(lat, lon, listener, errorListener);
    }

    /**
     * コンストラクタ
     *
     * @param lat           緯度
     * @param lon           軽度
     * @param listener      正常終了時のネットワークレスポンス
     * @param errorListener 異常終了時のネットワークレスポンス
     */
    public WeatherRequest(String lat, String lon, WeatherRequestResponseListener listener, Response.ErrorListener errorListener) {
        super(Method.GET, AppConstants.BASE_URL+"?lat="+lat+"&lon="+lon+"&APPID="+AppConstants.APP_ID, errorListener);

        // 正常時終了時に返却するクラス型セット
        this.clazz = WeatherEntity.class;

        // レスポンスリスナーセット
        this.listener = listener;

        // パラメータセット
//        params = new HashMap<>();
//        params.put("lat", lat);
//        params.put("lon", lon);
//        params.put("cnt", "1");
//        params.put("APPID", AppConstants.APP_ID);
    }

    @Override
    protected void deliverResponse(WeatherEntity response) {
        // 成形したデータを返す
        // リスナーが存在すればレスポンスを返す
        if (this.listener != null) {
            this.listener.onResponse(response);
        } else {
            deliverError(new VolleyError(""));
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        // エラーレスポンス
        super.deliverError(error);
    }


    @Override
    protected Response<WeatherEntity> parseNetworkResponse(NetworkResponse response) {
        // データを成形する
        // 成功：deliverResponse
        // 失敗：deliverError
        try {
            if (response != null && response.data != null && response.headers != null) {
                String json = new String(
                        response.data,
                        HttpHeaderParser.parseCharset(response.headers));
                return Response.success(
                        gson.fromJson(json, clazz),
                        HttpHeaderParser.parseCacheHeaders(response));
            } else {
                return Response.error(new ParseError(new NullPointerException("")));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
