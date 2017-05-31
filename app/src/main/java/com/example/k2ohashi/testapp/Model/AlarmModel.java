package com.example.k2ohashi.testapp.model;

/**
 * Created by k2ohashi on 17/05/12.
 */
public class AlarmModel {

    long id;
    String time;
    boolean alarmSwitch;
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

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public boolean getAlarmSwitch() {
        return alarmSwitch;
    }
    public void setAlarmSwitch(boolean alarmSwitch) {
        this.alarmSwitch = alarmSwitch;
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

    public boolean getTuesday(){
        return isTuesday;
    }
    public void setTuesday(boolean isTuesday){
        this.isTuesday = isTuesday;
    }

    public boolean getWednesday(){
        return isWednesday;
    }
    public void setWednesday(boolean isWednesday){
        this.isWednesday = isWednesday;
    }

    public boolean getThersday(){
        return isThersday;
    }
    public void setThersday(boolean isThersday){
        this.isThersday = isThersday;
    }

    public boolean getFriday(){
        return isFriday;
    }
    public void setFriday(boolean isFriday){
        this.isFriday = isFriday;
    }

    public boolean getSataday(){
        return isSataday;
    }
    public void setSataday(boolean isSataday){
        this.isSataday = isSataday;
    }
}
