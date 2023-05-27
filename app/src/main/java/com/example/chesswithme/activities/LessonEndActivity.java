package com.example.chesswithme.activities;

import static com.example.chesswithme.activities.AppActivity.usersList;
import static com.example.chesswithme.activities.RegisterActivity.authController;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.chessboard.Board;
import com.example.chesswithme.databinding.ActivityEndLessonBinding;
import com.example.chesswithme.firebase.ChessUserInfo;

public class LessonEndActivity extends AppCompatActivity {

    ActivityEndLessonBinding binding;
    private final int[] levels_array = new int[] {0, 20, 50, 90, 140, 200, 270, 350, 440, 540};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndLessonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle arguments = getIntent().getExtras();

        int total_points = arguments.getInt("total_points");
        int mistakes = arguments.getInt("mistakes");
        int golden_pawns_number = 0;

        binding.pointsScoredLesson.setText(String.valueOf(total_points));
        if(mistakes == 0) {
            golden_pawns_number = 1;
            binding.goldenPawnsScored.setText(String.valueOf(1));
        } else {
            binding.goldenPawnsScored.setText(String.valueOf(0));
        }

        for(ChessUserInfo user : usersList) {
            if(user.getEmail().equals(authController.getUser().getEmail())) {
                Board.firebaseReceiver.currentUserReference.child("allTimePoints").setValue(user.getAllTimePoints() + total_points);
                Board.firebaseReceiver.currentUserReference.child("completedLessons").setValue(user.getCompletedLessons() + 1);
                Board.firebaseReceiver.currentUserReference.child("goldenPawns").setValue(user.getGoldenPawns() + golden_pawns_number);
                Board.firebaseReceiver.currentUserReference.child("dailyPoints").setValue(user.getDailyPoints() + total_points);
                Board.firebaseReceiver.currentUserReference.child("weeklyPoints").setValue(user.getWeeklyPoints() + total_points);
                Board.firebaseReceiver.currentUserReference.child("monthlyPoints").setValue(user.getMonthlyPoints() + total_points);
                Board.firebaseReceiver.currentUserReference.child("allTimePoints").setValue(user.getAllTimePoints() + total_points);
                for (int i = 0; i < levels_array.length; i++) {
                    if (user.getAllTimePoints() + total_points >= levels_array[i] && user.getAllTimePoints() + total_points <= levels_array[i + 1]) {
                        Board.firebaseReceiver.currentUserReference.child("level").setValue(i + 1);
                        binding.level.setText(String.valueOf(i + 1) + "(+" + total_points + ")");
                        break;
                    }
                }
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
//
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
//        alphaAnimation.setDuration(3000);
//        alphaAnimation.setFillAfter(true);
//        binding.pointsScoredLessonText.setVisibility(View.VISIBLE);
//        binding.pointsScoredLesson.setVisibility(View.VISIBLE);
//        binding.pointsScoredLessonText.startAnimation(alphaAnimation);
//        binding.pointsScoredLesson.startAnimation(alphaAnimation);
//        binding.pointsScoredLessonText.setAlpha(1);
//        binding.pointsScoredLesson.setAlpha(1);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        binding.goldenPawnsScored.setVisibility(View.VISIBLE);
//        binding.goldenPawnsScoredText.setVisibility(View.VISIBLE);
//        binding.goldenPawnImage.setVisibility(View.VISIBLE);
//        binding.goldenPawnsScored.startAnimation(alphaAnimation);
//        binding.goldenPawnsScoredText.startAnimation(alphaAnimation);
//        binding.goldenPawnImage.startAnimation(alphaAnimation);
//        binding.goldenPawnImage.setAlpha(1);
//        binding.goldenPawnImage.setBackgroundResource(R.drawable.golden_pawn_image);
//        binding.goldenPawnsScoredText.setAlpha(1);
//        binding.goldenPawnsScored.setAlpha(1);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        binding.levelText.setVisibility(View.VISIBLE);
//        binding.level.setVisibility(View.VISIBLE);
//        binding.levelText.startAnimation(alphaAnimation);
//        binding.level.startAnimation(alphaAnimation);
//        binding.levelText.setAlpha(1);
//        binding.level.setAlpha(1);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        binding.continueButton.setVisibility(View.VISIBLE);
//        binding.continueButton.startAnimation(alphaAnimation);
//        binding.continueButton.setAlpha(1);
//        binding.continueButton.setBackgroundResource(R.color.card_color_lesson);



        binding.continueButton.setOnClickListener(view -> {
            startActivity(new Intent(this, AppActivity.class));
            finish();
        });






    }
}
