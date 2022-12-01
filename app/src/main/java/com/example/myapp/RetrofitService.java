package com.example.myapp;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/public/sample/data")
    Call<Map<String, Object>> getSampleData(@Query("param") String param);



}
