package com.example.k2ohashi.testapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.k2ohashi.testapp.Fragment.DetailFragment;
import com.example.k2ohashi.testapp.Fragment.FragmentCallBackListener;
import com.example.k2ohashi.testapp.Fragment.HomeFragment;
import com.example.k2ohashi.testapp.Fragment.SettingFragment;
import com.example.k2ohashi.testapp.R;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,FragmentCallBackListener{

    private Fragment tabFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position){
                    case 0:
                        tabFragment =  SettingFragment.newInstance();
                        break;
                    case 1:
                        tabFragment =  HomeFragment.newInstance();
                        break;
                    case 2:
                        tabFragment =  DetailFragment.newInstance();
                        break;
                }

                return tabFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "tab " + (position + 1);
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        //オートマチック方式: これだけで両方syncする
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (position){
            case 0:
                setActionbar("設定");
                break;
            case 1:
                setActionbar("ホーム");
                break;
            case 2:
                setActionbar("詳細");
                break;
        }

    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void setActionbar(String title){
        setTitle(title);
    }

}