package com.example.habittest;

public class HabitListItem {

    private String name;
    private String time;
    private String days;
    private String picPath;
    private String aim;

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDays() {
        return days;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }


    public HabitListItem(String name, String time, String days, String picPath,String aim) {
        this.name = name;
        this.time = time;
        this.days = days;
        this.picPath = picPath;
        this.aim=aim;
    }


}
