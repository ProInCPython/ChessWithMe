package com.example.chesswithme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chesswithme.model.GameView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}