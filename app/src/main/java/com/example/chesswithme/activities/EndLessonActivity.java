package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.databinding.ActivityLessonEndBinding;

public class EndLessonActivity extends AppCompatActivity {

    ActivityLessonEndBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLessonEndBinding.inflate(getLayoutInflater());


        binding.continueButton.setOnClickListener(view -> {
            startActivity(new Intent(this, AppActivity.class));
            finish();
        });

    }
}

//        binding.goldenPawnsScored.setVisibility(View.INVISIBLE);
//        binding.continueButton.setVisibility(View.INVISIBLE);
//        binding.goldenPawnsScoredText.setVisibility(View.INVISIBLE);
//        binding.pointsScoredLessonText.setVisibility(View.INVISIBLE);
//        binding.pointsScoredLesson.setVisibility(View.INVISIBLE);
//        binding.levelText.setVisibility(View.INVISIBLE);
//        binding.level.setVisibility(View.INVISIBLE);
//        binding.goldenPawnImage.setVisibility(View.INVISIBLE);


//        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
//        alphaAnimation.setDuration(500);
//        alphaAnimation.setFillAfter(true);
//        binding.pointsScoredLessonText.setVisibility(View.VISIBLE);
//        binding.pointsScoredLesson.setVisibility(View.VISIBLE);
//        binding.pointsScoredLessonText.startAnimation(alphaAnimation);
//        binding.pointsScoredLesson.startAnimation(alphaAnimation);
//        binding.pointsScoredLessonText.setAlpha(1);
//        binding.pointsScoredLesson.setAlpha(1);
//        binding.goldenPawnsScored.setVisibility(View.VISIBLE);
//        binding.goldenPawnsScoredText.setVisibility(View.VISIBLE);
//        binding.goldenPawnImage.setVisibility(View.VISIBLE);
//        binding.goldenPawnsScored.startAnimation(alphaAnimation);
//        binding.goldenPawnsScoredText.startAnimation(alphaAnimation);
//        binding.goldenPawnImage.startAnimation(alphaAnimation);
//        binding.goldenPawnImage.setAlpha(1);
//        binding.goldenPawnsScoredText.setAlpha(1);
//        binding.goldenPawnsScored.setAlpha(1);
//
//        binding.levelText.setVisibility(View.VISIBLE);
//        binding.level.setVisibility(View.VISIBLE);
//        binding.levelText.startAnimation(alphaAnimation);
//        binding.level.startAnimation(alphaAnimation);
//        binding.levelText.setAlpha(1);
//        binding.level.setAlpha(1);
//
//        binding.continueButton.setVisibility(View.VISIBLE);
//        binding.continueButton.startAnimation(alphaAnimation);
//        binding.continueButton.setAlpha(1);
//        binding.continueButton.setBackgroundResource(R.color.card_color_lesson);
