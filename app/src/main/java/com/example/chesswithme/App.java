package com.example.chesswithme;

import android.app.Application;

import androidx.room.Room;

import com.example.chesswithme.database.room.Database;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class App extends Application {

    static DatabaseReference databaseReference;
    static FirebaseDatabase database;

    @Override
    public void onCreate() {
        database = FirebaseDatabase.getInstance("https://chesswithme-3bc29-default-rtdb.europe-west1.firebasedatabase.app");
        databaseReference = database.getReference();
        super.onCreate();
    }

    public static DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public static FirebaseDatabase getDatabase() {
        return database;
    }

}
