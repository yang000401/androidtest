package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {


    EditText et_data;
    Button btn_save;
    Database database;
    Dao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        database = Database.getInstance(this);
        dao = database.getDao();

        et_data = findViewById(R.id.data);
        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et_data.getText() != null
                        ? et_data.getText().toString()
                        : "";
                if (data.length() > 0) {
                    //
                    Entity entity = new Entity();
                    entity.data = data;
                    dao.insertEntity(entity);
                }
            }
        });
    }
}