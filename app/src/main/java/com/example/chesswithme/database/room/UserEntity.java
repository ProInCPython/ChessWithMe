package com.example.chesswithme.database.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class UserEntity {

    @PrimaryKey
    public int password;

    public String email;
    public String join_date;

    public UserEntity(String email, int password, String join_date) {
        this.email = email;
        this.join_date = join_date;
        this.password = password;
    }
//
//    public int getPassword() {
//        return password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getJoin_date() {
//        return join_date;
//    }
}
