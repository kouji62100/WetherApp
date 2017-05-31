package com.example.k2ohashi.testapp.model;

/**
 * Created by k2ohashi on 17/05/23.
 */
public class WeatherModel {

    private String areaName;
    private String weather;
    private String temp;

    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
}
