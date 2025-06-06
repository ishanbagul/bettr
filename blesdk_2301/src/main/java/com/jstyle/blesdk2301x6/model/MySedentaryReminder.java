package com.jstyle.blesdk2301x6.model;

/**
 * Created by Administrator on 2018/1/16.
 */

public class MySedentaryReminder extends SendData{
    int startHour;
    int startMinute;
    int endHour;
    int endMinute;
    int week;
    int intervalTime;
    int leastStep;
    boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public int getLeastStep() {
        return leastStep;
    }

    public void setLeastStep(int leastStep) {
        this.leastStep = leastStep;
    }

    @Override
    public String toString() {
        return "MySedentaryReminder{" +
                "startHour=" + startHour +
                ", startMinute=" + startMinute +
                ", endHour=" + endHour +
                ", endMinute=" + endMinute +
                ", week=" + week +
                ", intervalTime=" + intervalTime +
                ", leastStep=" + leastStep +
                ", enable=" + enable +
                '}';
    }
}
