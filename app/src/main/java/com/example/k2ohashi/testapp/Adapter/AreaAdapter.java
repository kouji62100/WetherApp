package com.example.k2ohashi.testapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.k2ohashi.testapp.Databese.AreaRealmModel;
import com.example.k2ohashi.testapp.Model.WeatherModel;
import com.example.k2ohashi.testapp.OnRecyclerListener;
import com.example.k2ohashi.testapp.R;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by k2ohashi on 17/05/22.
 */
public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private ArrayList<WeatherModel> mData;
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
            viewHolder.textView.setText(mData.get(i).getAreaName());
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

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.area_name_text);
        }
    }
}
