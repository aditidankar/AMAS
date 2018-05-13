package com.example.android.amas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiInterface {
    @GET("phpHODLogin.php")
    Call<List<RetrofitArrayData>> HODLogin(@Query("userid") String userid, @Query("password") String password);

    @GET("phpStudentLogin.php")
    Call<List<RetrofitArrayData>> StudentLogin(@Query("userid") String userid, @Query("password") String password);

    @GET("phpStaffLogin.php")
    Call<List<RetrofitArrayData>> StaffLogin(@Query("userid") String userid, @Query("password") String password);
}
