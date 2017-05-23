package com.example.k2ohashi.testapp.Databese;

import io.realm.RealmObject;

/**
 * Created by k2ohashi on 17/05/22.
 */
public class AreaRealmModel extends RealmObject{
    private String areaName;
    private String lat;
    private String lon;

    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
}
