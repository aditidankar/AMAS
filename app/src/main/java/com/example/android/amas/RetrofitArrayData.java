package com.example.android.amas;

import com.google.gson.annotations.SerializedName;

public class RetrofitArrayData {
    @SerializedName("userid")
    private String UserID;

    @SerializedName("password")
    private String Password;

    @SerializedName("status")
    private String Status;

    public String getUserID() {
        return UserID;
    }

    public String getPassword() {
        return Password;
    }

    public String getStatus() {
        return Status;
    }
}
