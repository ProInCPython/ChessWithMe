package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.controller.AuthController;
import com.example.chesswithme.databinding.ActivityEnterBinding;

public class EnterActivity extends AppCompatActivity {
    ActivityEnterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AuthController authController = new AuthController();
        if(authController.isAuth()) {
            startActivity(new Intent(this, AppActivity.class));
            finish();
        }
        binding.startNow.setOnClickListener(view -> {
            if(authController.isAuth()) {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            } else {
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
            }
        }
        );

    }
}
