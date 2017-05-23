package com.example.k2ohashi.testapp.Model;

import java.util.ArrayList;

/**
 * Created by k2ohashi on 17/05/19.
 */
public class WeatherEntity {
    public int cod;
    public double message;
    public int cnt;
    public ArrayList<List> list;
    public class List {
        public int dt;
        public Main main;
        public class Main{
            public double temp;
            public double temp_min;
            public double temp_max;
            public double pressure;
            public double sea_leval;
            public double grnd_level;
            public int humidity;
            public double temp_kf;
        }
        public ArrayList<Weather> weather;
        public class Weather{
            public int id;
            public String main;
            public String description;
            public String icon;
        }
        public Clouds clouds;
        public class Clouds{
            public int all;
        }
        public Wind wind;
        public class Wind{
            public double speed;
            public double deg;
        }
        public Sys sys;
        public class Sys{
            public String pod;
        }
        public String dt_txt;
    }
    public City city;
    public class City{
        public int id;
        public String name;
        public Coord coord;
        public class Coord{
            public double lat;
            public double lon;
        }
        public String country;
    }
}