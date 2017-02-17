package com.zeroeur.ltmapplication;

/**
 * Created by Luca on 16/02/2017.
 */

public class BusinessCard {

    String name, email, phoneNumber,course,address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BusinessCard(String name, String email, String phoneNumber, String course, String address){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCourse() {
        return course;
    }

    public String getAddress() {
        return address;
    }



}
