package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.chesswithme.databinding.ActivityEnterBinding;

public class EnterActivity extends AppCompatActivity {
    ActivityEnterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.startNow.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        );

    }
}
