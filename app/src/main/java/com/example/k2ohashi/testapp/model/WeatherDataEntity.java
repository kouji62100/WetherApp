package com.example.k2ohashi.testapp.model;

import java.util.ArrayList;

/**
 * Created by k2ohashi on 17/05/25.
 */
public class WeatherDataEntity {
    public class Coord{
        public double lon;
        public double lat;
    }
    public Coord coord;
    public class Sys{
        public int type;
        public int id;
        public double message;
        public String country;
        public int sunrise;
        public int sunset;
    }
    public Sys sys;
    public class Weather{
        public int id;
        public String main;
        public String description;
        public String icon;
    }
    public ArrayList<Weather> weather;
    public String base;
    public class Main{
        public double temp;
        public int humidity;
        public double pressure;
        public double temp_min;
        public double temp_max;
    }
    public Main main;
    public class Wind{
        public double speed;
        public double deg;
    }
    public Wind wind;
    public class Clouds{
        public int all;
    }
    public Clouds clouds;
    public int dt;
    public int id;
    public String name;
    public int cod;
}
