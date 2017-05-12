package com.example.k2ohashi.testapp.Fragment;

/**
 * Created by k2ohashi on 17/05/12.
 */
public class AlarmModel {

    long id;
    String name;
    String tweet;
    boolean isSunday;
    boolean isMonday;
    boolean isTuesday;
    boolean isWednesday;
    boolean isThersday;
    boolean isFriday;
    boolean isSataday;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getSunday() {
        return isSunday;
    }
    public void setSunday(boolean isSunday) {
        this.isSunday = isSunday;
    }

    public boolean getMonday() {
        return isMonday;
    }
    public void setMonday(boolean isMonday) {
        this.isMonday = isMonday;
    }
}
