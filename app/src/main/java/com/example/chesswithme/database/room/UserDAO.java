package com.example.chesswithme.database.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM Users")
    List<UserEntity> getAll();

    @Insert
    void insert(UserEntity user);

    @Query("SELECT * FROM Users WHERE password = :password")
    UserEntity getPassword(int password);

    @Update
    void update(UserEntity user);

    @Delete
    void delete(UserEntity user);
}
