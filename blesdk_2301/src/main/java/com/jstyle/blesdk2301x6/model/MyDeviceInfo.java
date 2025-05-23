package com.jstyle.blesdk2301x6.model;

/**
 * Created by Administrator on 2018/4/9.
 */

public class MyDeviceInfo extends SendData{

    boolean DistanceUnit;//1 mile（true）,0km(false)
    boolean is12Hour;//1（12小时）（true），0（24小时制）(false)
    boolean Bright_screen;//1 turn on the bright screen, 0 turn off the bright screen
    boolean Fahrenheit_or_centigrade;//Fahrenheit or centigrade
    boolean isHorizontalScreen;//1 Horizontal screen, 0 Vertical screen
    boolean Night_mode;//夜间模式
    boolean Temperature_unit;//夜间模式
    boolean Social_distance_switch;//社交距离开关 Social distance switch
    int  LauageNumber=-1;//中英文切换 Chinese_English_switch
    int baseheart=60;//Basic heart rate
    int ScreenBrightness=-1;//Screen brightness  屏幕亮度0-5
    int Dialinterface=-1;//表盘更换 Dial replacement 0-10

    public boolean isTemperature_unit() {
        return Temperature_unit;
    }

    public void setTemperature_unit(boolean temperature_unit) {
        Temperature_unit = temperature_unit;
    }

    public int getLauageNumber() {
        return LauageNumber;
    }

    public void setLauageNumber(int lauageNumber) {
        LauageNumber = lauageNumber;
    }

    public boolean isSocial_distance_switch() {
        return Social_distance_switch;
    }

    public void setSocial_distance_switch(boolean social_distance_switch) {
        Social_distance_switch = social_distance_switch;
    }

    public boolean isNight_mode() {
        return Night_mode;
    }

    public void setNight_mode(boolean night_mode) {
        Night_mode = night_mode;
    }

    public boolean isDistanceUnit() {
        return DistanceUnit;
    }

    public void setDistanceUnit(boolean distanceUnit) {
        DistanceUnit = distanceUnit;
    }

    public boolean isIs12Hour() {
        return is12Hour;
    }

    public void setIs12Hour(boolean is12Hour) {
        this.is12Hour = is12Hour;
    }

    public boolean isBright_screen() {
        return Bright_screen;
    }

    public void setBright_screen(boolean bright_screen) {
        Bright_screen = bright_screen;
    }

    public boolean isFahrenheit_or_centigrade() {
        return Fahrenheit_or_centigrade;
    }

    public void setFahrenheit_or_centigrade(boolean fahrenheit_or_centigrade) {
        Fahrenheit_or_centigrade = fahrenheit_or_centigrade;
    }

    public boolean isHorizontalScreen() {
        return isHorizontalScreen;
    }

    public void setHorizontalScreen(boolean horizontalScreen) {
        isHorizontalScreen = horizontalScreen;
    }

    public int getBaseheart() {
        return baseheart;
    }

    public void setBaseheart(int baseheart) {
        this.baseheart = baseheart;
    }

    public int getScreenBrightness() {
        return ScreenBrightness;
    }

    public void setScreenBrightness(int screenBrightness) {
        ScreenBrightness = screenBrightness;
    }

    public int getDialinterface() {
        return Dialinterface;
    }

    public void setDialinterface(int dialinterface) {
        Dialinterface = dialinterface;
    }
}
