package com.jstyle.blesdk2301x6.model;


/**
 * Created by Administrator on 2022/2/18.
 */
public class UserInfo {

    String phone="";
    String name="";
    String gender;//0男，1女
    String age="";//18
    String height="";//175
    String weight="";//75
    String ecgTitle="";
    String ecgReportTips="";
    String date="";

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEcgTitle() {
        return ecgTitle;
    }

    public void setEcgTitle(String ecgTitle) {
        this.ecgTitle = ecgTitle;
    }

    public String getEcgReportTips() {
        return ecgReportTips;
    }

    public void setEcgReportTips(String ecgReportTips) {
        this.ecgReportTips = ecgReportTips;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", ecgTitle='" + ecgTitle + '\'' +
                ", ecgReportTips='" + ecgReportTips + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
