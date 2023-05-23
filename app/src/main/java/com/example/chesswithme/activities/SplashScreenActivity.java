package com.example.chesswithme.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.controller.AuthController;
import com.example.chesswithme.firebase.ChessUserInfo;

import java.util.ArrayList;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {
    public static ArrayList<ChessUserInfo> usersList = Board.firebaseReceiver.receiveUsersData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, EnterActivity.class));
        finish();

    }
}
