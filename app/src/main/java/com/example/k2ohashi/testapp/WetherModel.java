package com.example.k2ohashi.testapp;

import java.util.ArrayList;

/**
 * Created by k2ohashi on 17/05/19.
 */
public class WetherModel {
    public int code;
    public int message;
    public int cnt;
    public ArrayList<List> list;
    public class List {
        public int dt;
        public Main main;
        public class Main{
            public int temp;
            public int temp_min;
            public int temp_max;
            public int pressure;
            public int sea_leval;
            public int grnd_level;
            public int humidity;
            public int temp_kf;
        }
        public class
    }
}
