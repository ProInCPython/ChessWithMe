package com.example.chesswithme.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.adapters.EnterPagerAdapter;
import com.example.chesswithme.databinding.ActivityEnterBinding;

public class EnterActivity extends AppCompatActivity {
    ActivityEnterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        new Thread(() -> {
//            try {
//                Thread.sleep(1500);
//                runOnUiThread(() -> {
//                    binding.mainIcon.setVisibility(View.VISIBLE);
//                });
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
        binding.pager.setAdapter(new EnterPagerAdapter(getSupportFragmentManager()));
        binding.tabs.setupWithViewPager(binding.pager);
    }
}
