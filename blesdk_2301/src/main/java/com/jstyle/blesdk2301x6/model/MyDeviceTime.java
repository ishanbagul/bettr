package com.jstyle.blesdk2301x6.model;

import java.util.Calendar;

/**
 * Created by Administrator on 2018/1/16.
 */

public class MyDeviceTime extends SendData{
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;

    public MyDeviceTime() {
        Calendar calendar=Calendar.getInstance();
        this.year=calendar.get(Calendar.YEAR);
        this.month=calendar.get(Calendar.MONTH)+1;
        this.day=calendar.get(Calendar.DAY_OF_MONTH);
        this.hour=calendar.get(Calendar.HOUR_OF_DAY);
        this.minute=calendar.get(Calendar.MINUTE);
        this.second=calendar.get(Calendar.SECOND);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "MyDeviceTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
