package com.example.k2ohashi.testapp.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.k2ohashi.testapp.Fragment.DetailFragment;
import com.example.k2ohashi.testapp.Fragment.HomeFragment;
import com.example.k2ohashi.testapp.Fragment.SettingFragment;
import com.example.k2ohashi.testapp.R;

/**
 * Created by k2ohashi on 17/05/12.
 */
public class AlarmCreateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_create);
    }
}
