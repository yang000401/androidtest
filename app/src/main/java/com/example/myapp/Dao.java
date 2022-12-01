package com.example.myapp;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("select * from tb_sample")
    List<Entity> selectEntityList();

    @Insert
    void insertEntity(Entity entity);
}
