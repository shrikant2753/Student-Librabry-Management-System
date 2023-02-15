package com.example.Student_Library_Management_System.DTOs;

public class StudentUpdateMob {
    //DTOs are very specific to the API calls
    //it depends on api calls
    private int id;
    private String mobileNo;

    public StudentUpdateMob(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
