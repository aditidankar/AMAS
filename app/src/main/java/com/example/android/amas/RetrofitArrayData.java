package com.example.android.amas;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class RetrofitArrayData {
    @SerializedName("userid")
    private String UserID;

    @SerializedName("password")
    private String Password;

    @SerializedName("status")
    private String Status;

    @SerializedName("fname")
    private String Fname;

    @SerializedName("lname")
    private String Lname;


    public String getUserID() {
        return UserID;
    }

    public String getPassword() {
        return Password;
    }

    public String getStatus() {
        return Status;
    }

    public String getFname(){
        return Fname;
    }

    public String getLname() {
        return Lname;
    }
}
