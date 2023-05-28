package com.example.chesswithme.activities;

import static com.example.chesswithme.chessboard.Board.firebaseReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.chessboard.BoardView;
import com.example.chesswithme.databinding.ActivityLessonBinding;
import com.example.chesswithme.firebase.FirebaseReceiver;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {
    ActivityLessonBinding binding;
    BoardView board;
    String data;
    private boolean isEndTheory = false;
    private boolean isNextChallenge = false;
    private int mistakes = 0;
    private int total_mistakes = 0;
    private int total_points = 0;
    private int challenge_points = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        board = binding.board;
        binding.mistakeScreen.setVisibility(View.INVISIBLE);
        binding.check.setVisibility(View.GONE);
        Bundle arguments = getIntent().getExtras();
        binding.titleText.setText(arguments.getString("simple_lesson_name"));
        binding.text.setText("Приветствую в очередном уроке!");
        firebaseReceiver.receiveData("AppData/Modules/" + arguments.getString("module") + "/" + arguments.getString("database_lesson_name"), board);

//        binding.button.setAlpha(0);
//        binding.button2.setAlpha(0);
//        binding.send.setAlpha(0);
//        binding.newGame.setAlpha(0);
//        binding.challengeNumber.setAlpha(0);
//        binding.moduleNumber.setAlpha(0);
//        binding.userColor.setAlpha(0);
//        binding.lessonName.setAlpha(0);





//        Board.newGame();
//        BoardView.userColor = Board.userColor;
//        binding.text.setText("Привет! В этом уроке мы поговорим о том, как ходит пешка. Посмотри на доску.");


        //ON CLICK LISTENERS

//        binding.button.setOnClickListener(view -> {
//            data = Board.getString();
////            binding.text.setText(data);
//        });
//        binding.button2.setOnClickListener(view -> {
//            if (data != null) {
////                Board.load(data, "white");
//            }
//        });
//        binding.send.setOnClickListener(view -> {
//            if (data != null) {
//                String module_number = binding.moduleNumber.getText().toString();
//                String lesson_name = binding.lessonName.getText().toString();
//                String challenge_number = binding.challengeNumber.getText().toString();
//                String userColor = binding.userColor.getText().toString();
//                ArrayList<String> array = new ArrayList<>();
//                array.add("В этом задании тебе нужно провести одну из своих пешек в ферзи!");
//                array.add("Прекрасная работа!");
//                ArrayList<String> array2 = new ArrayList<>();
//                array2.add("В этом уроке мы поговорим о пешке!");
//                array2.add("Теперь перейдем к практике!");
//
//                LessonObject lessonObject = new LessonObject();
//                //data, array, "Queen on the board", userColor
//                lessonObject.setInitial_position(data);
//                lessonObject.setFinish_conditions("Queen on the board");
//                lessonObject.setUserColor(userColor);
//
//                InitialPosition init = new InitialPosition();
//                init.setValue(data);
//
//
//                databaseReference.child(module_number).child(lesson_name).child(challenge_number).setValue(lessonObject);
//                databaseReference.child(module_number).child(lesson_name).child("description").setValue(array);
//                databaseReference.child(module_number).child(lesson_name).child("theory").setValue(array2);
//                databaseReference.child(module_number).child(lesson_name).child("init_pos_theory").setValue(init);
//            }
//        });
//
//        binding.newGame.setOnClickListener(view -> {
//            Board.newGame();
//        });
//        binding.send.setOnClickListener(view -> {
//            databaseReference.child("1").child("Pawn").child("init_pos_theory").setValue("4,4,white,Pawn;");
//        });
//
        binding.scrollTextHolder.setOnClickListener(view -> {
            if(!isEndTheory) {
                if(firebaseReceiver.getTheory().size() == firebaseReceiver.getTheory_index()) {
                    isEndTheory = !isEndTheory;
                    firebaseReceiver.setTheory_index(0);
                    binding.check.setVisibility(View.VISIBLE);
                    mistakes = 0;
                    total_points = 0;
                    challenge_points = 3;
                    nextChallenge();
                } else {
                    nextTheory();
                }
            }
            if(isNextChallenge) {
                total_points += challenge_points;
                total_mistakes += mistakes;
                isNextChallenge = !isNextChallenge;
                FirebaseReceiver.board.isNextChallenge = !FirebaseReceiver.board.isNextChallenge;
                mistakes = 0;
                challenge_points = 3;
                nextChallenge();
            }
            if(firebaseReceiver.isEndLesson) {
                firebaseReceiver.isEndLesson = !firebaseReceiver.isEndLesson;
                Intent intent = new Intent(LessonActivity.this, LessonEndActivity.class);
                intent.putExtra("mistakes", total_mistakes);
                intent.putExtra("total_points", total_points);
                startActivity(intent);
                finish();
            }
        });

        binding.check.setOnClickListener(view -> {
            if(firebaseReceiver.isEndLesson) {

            } else {
                if(FirebaseReceiver.board.isNextChallenge) {
                    isNextChallenge = !isNextChallenge;
                    FirebaseReceiver.board.isNextChallenge = !FirebaseReceiver.board.isNextChallenge;
                    nextChallenge(true);
                } else {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 0.45f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setFillAfter(false);
                    binding.mistakeScreen.setVisibility(View.VISIBLE);
                    binding.mistakeScreen.startAnimation(alphaAnimation);
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.45f, 0f);
                    alphaAnimation2.setDuration(500);
                    alphaAnimation2.setFillAfter(true);
                    binding.mistakeScreen.setVisibility(View.INVISIBLE);
                    mistakes += 1;
                    if(challenge_points != 1) {
                        challenge_points -= 1;
                    }

                }

            }
        });


    }

    public void update() {
        if (board == null) return;
        board.invalidate();
    }

    @Override
    public void onBackPressed() {

    }

    public void nextChallenge() {
        String challenge_result = firebaseReceiver.nextChallenge();
        binding.text.setText(challenge_result);
        board.invalidate();
    }

    public void nextChallenge(boolean isNextChallenge) {
        String challenge_result = firebaseReceiver.nextChallenge(isNextChallenge);
        binding.text.setText(challenge_result);
    }

    private void nextTheory() {
        String theory_result = firebaseReceiver.nextTheory(board);
        binding.text.setText(theory_result);
    }

    public BoardView getBoard() {
        return board;
    }




}








