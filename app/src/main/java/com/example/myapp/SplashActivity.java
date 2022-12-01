package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    List<Drawable> drawableList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    imageView = findViewById(R.id.imageView);
    drawableList.add(getResources().getDrawable(R.drawable.expressionless));
    drawableList.add(getResources().getDrawable(R.drawable.expressionless));
    getAnimation().start();

    }

    private Thread getAnimation() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 4; i++) {
                    Drawable drawable = drawableList.get(i % 2);
                    imageView.setImageDrawable(drawable);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                }
                startActivity(new Intent(SplashActivity.this, Main.class));
                SplashActivity.this.finish();
            }
        });

    }
}