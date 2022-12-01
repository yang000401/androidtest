package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class PrefActivity extends AppCompatActivity {

    Switch sw_toggle;
    TextView today;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        sharedPreferences = getSharedPreferences("pref_default", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        sw_toggle = findViewById(R.id.sw_toggle);
        sw_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean("checked", b);
                editor.apply();

            }
        });

        boolean checked = sharedPreferences.getBoolean("checked", false);
        sw_toggle.setChecked((checked));
    }
}