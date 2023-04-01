package com.example.chesswithme;

import android.app.Application;

import androidx.room.Room;

import com.example.chesswithme.database.room.Database;

public class App extends Application {
    private static App instance;
    private static Database database;

    @Override
    public void onCreate() {
        instance = this;
        database = Room.databaseBuilder(this, Database.class, "Users").build();
        super.onCreate();
    }

    public static App getInstance() {
        return instance;
    }

    public static Database getDatabase() {
        return database;
    }
}
