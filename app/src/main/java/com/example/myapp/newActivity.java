package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class newActivity extends AppCompatActivity {

    TextView tv_result;
    Button btn_get;

    Retrofit retrofit;
    RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        tv_result = findViewById(R.id.tv_result);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.1:8080")
                .addConverterFactory(GsonConverterFactory.create())
                        .build();

        retrofitService = retrofit.create(RetrofitService.class);

        btn_get = findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Map<String, Object>> request = retrofitService.getSampleData("datal");
                request.enqueue(new Callback<Map<String, Object>>() {
                    @Override
                    public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                        if(response.isSuccessful()){
                            Map<String, Object> body = response.body();
                            tv_result.setText("body="+body);
                        }else{
                            tv_result.setText("error="+response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                        tv_result.setText("fail="+t.getLocalizedMessage());
                    }
                });
            }
        });



    }
}