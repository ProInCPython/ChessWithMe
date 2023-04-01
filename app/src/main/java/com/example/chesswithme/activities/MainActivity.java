package com.example.chesswithme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.chesswithme.R;
import com.example.chesswithme.fragments.ScrollBarFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}