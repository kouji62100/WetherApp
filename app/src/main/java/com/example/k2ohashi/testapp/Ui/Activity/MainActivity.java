package com.example.k2ohashi.testapp.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.k2ohashi.testapp.databese.RealmHelper;
import com.example.k2ohashi.testapp.ui.fragment.DetailFragment;
import com.example.k2ohashi.testapp.ui.fragment.FragmentCallBackListener;
import com.example.k2ohashi.testapp.ui.fragment.HomeFragment;
import com.example.k2ohashi.testapp.ui.fragment.SettingFragment;
import com.example.k2ohashi.testapp.ui.fragment.WeatherFragment1;
import com.example.k2ohashi.testapp.ui.fragment.WeatherFragment2;
import com.example.k2ohashi.testapp.ui.fragment.WeatherFragment3;
import com.example.k2ohashi.testapp.ui.fragment.WeatherFragment4;
import com.example.k2ohashi.testapp.ui.fragment.WeatherFragment5;
import com.example.k2ohashi.testapp.R;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,FragmentCallBackListener,NavigationView.OnNavigationItemSelectedListener{

    private Fragment tabFragment = null;
    private FragmentManager fragmentManager = null;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        helper = new RealmHelper(getApplicationContext());

        /** Toolbar */
        final Toolbar mainBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(mainBar);

        /** DrawerToggle */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, mainBar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /** NavigationView Listener */
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        /** tab */
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position){
                    case 0:
                        if(helper.getAreaData().size() >= 1){
                            tabFragment =  WeatherFragment1.newInstance();
                        }
                        break;
                    case 1:
                        if(helper.getAreaData().size() >= 2) {
                            tabFragment =  WeatherFragment2.newInstance();
                        }
                        break;
                    case 2:
                        if(helper.getAreaData().size() >= 3) {
                            tabFragment =  WeatherFragment3.newInstance();
                        }
                        break;
                    case 3:
                        if(helper.getAreaData().size() >= 4) {
                            tabFragment =  WeatherFragment4.newInstance();
                        }
                        break;
                    case 4:
                        if(helper.getAreaData().size() >= 5) {
                            tabFragment =  WeatherFragment5.newInstance();
                        }
                        break;
                }

                return tabFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Weather " + (position + 1);
            }

            @Override
            public int getCount() {
                return helper.getAreaData().size();
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        //オートマチック方式: これだけで両方syncする
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(item.getItemId()){
            case R.id.menu_item1:
                changeContent(HomeFragment.newInstance(),DetailFragment.TAG,true);
                break;
            case R.id.menu_item2:
                changeContent(DetailFragment.newInstance(),DetailFragment.TAG,false);
                break;
            case R.id.menu_item3:
                changeContent(SettingFragment.newInstance(),SettingFragment.TAG,false);
                break;
            case R.id.menu_item4:
                break;
            case R.id.menu_item5:
                break;
            case R.id.menu_item6:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    /** ---------------------------------------------------------------------- */
    /** OnPageChangeListener                                                   */
    /** ---------------------------------------------------------------------- */

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

    public void changeContent(Fragment fragment, String tag, boolean tab) {

        if(tab){
            tabLayout.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.VISIBLE);
        }else{

            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);

            this.fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content_frame, fragment, tag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(tag)
                    .commitAllowingStateLoss();
        }
    }

}