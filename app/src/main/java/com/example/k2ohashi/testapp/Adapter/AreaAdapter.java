package com.example.k2ohashi.testapp.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.k2ohashi.testapp.WeatherApp;
import com.example.k2ohashi.testapp.model.WeatherModel;
import com.example.k2ohashi.testapp.OnRecyclerListener;
import com.example.k2ohashi.testapp.R;

import java.util.ArrayList;

/**
 * Created by k2ohashi on 17/05/22.
 */
public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    public ArrayList<WeatherModel> mData;
    private Context mContext;
    private OnRecyclerListener mListener;

    public AreaAdapter(Context context, ArrayList<WeatherModel> data, OnRecyclerListener listener) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
        mListener = listener;
    }

    @Override
    public AreaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 表示するレイアウトを設定
        return new ViewHolder(mInflater.inflate(R.layout.area_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        // データ表示
        if (mData != null && mData.size() > i && mData.get(i) != null) {
            viewHolder.areaText.setText(mData.get(i).getAreaName());
            viewHolder.tempText.setText(mData.get(i).getTemp());
            String imageUrl = "http://openweathermap.org/img/w/"+mData.get(i).getWeather()+".png";
            setImageLoader(viewHolder.weatherImage,imageUrl);
        }

        // クリック処理
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRecyclerClicked(v, i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        } else {
            return 0;
        }
    }

    // ViewHolder(固有ならインナークラスでOK)
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView areaText;
        ImageView weatherImage;
        TextView tempText;

        public ViewHolder(View itemView) {
            super(itemView);
            areaText = (TextView) itemView.findViewById(R.id.area_name_text);
            weatherImage = (ImageView) itemView.findViewById(R.id.weather_image);
            tempText = (TextView) itemView.findViewById(R.id.temp_text);
        }
    }

    public void setImageLoader(ImageView imageView, String imageUrl) {
        // 画像
        if (imageView != null && imageUrl != null) {
            try {
                ImageLoader.ImageContainer imageContainer =
                        (ImageLoader.ImageContainer) imageView.getTag();

                if (imageContainer != null) {
                    imageContainer.cancelRequest();
                }

            } catch (ClassCastException ignore) {
            }

            ImageLoader.ImageListener listener =
                    ImageLoader.getImageListener(imageView, R.drawable.cast_abc_scrubber_control_off_mtrl_alpha, R.drawable.cast_abc_scrubber_control_off_mtrl_alpha);
            imageView.setTag(WeatherApp.get().getImageLoader().get(imageUrl, listener));
        }
    }
}
