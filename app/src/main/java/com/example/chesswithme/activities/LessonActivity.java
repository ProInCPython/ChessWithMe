package com.example.chesswithme.activities;

import static android.content.ContentValues.TAG;

import static com.example.chesswithme.chessboard2.Board.firebaseReceiver;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.App;
import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.chessboard2.BoardView;
import com.example.chesswithme.chessboard2.Coordinate;
import com.example.chesswithme.databinding.ActivityLessonBinding;
import com.example.chesswithme.firebase.FirebaseReceiver;
import com.example.chesswithme.firebase.InitialPosition;
import com.example.chesswithme.firebase.LessonObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonActivity extends AppCompatActivity {
    ActivityLessonBinding binding;
    BoardView board;
    String data;
    private boolean isEndTheory = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        board = binding.board;
        binding.button.setVisibility(View.GONE);
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
                    binding.button.setVisibility(View.VISIBLE);
                    nextChallenge();
                } else {
                    nextTheory();
                }
            }
        });

        binding.button.setOnClickListener(view -> {
            if(firebaseReceiver.isEndLesson) {
                binding.text.setText(firebaseReceiver.getDescription().get(firebaseReceiver.getDescription().size() - 1));
            } else {
                nextChallenge();
            }
        });


    }

    public void update() {
        if (board == null) return;
        board.invalidate();
    }

    @Override
    public void onBackPressed() {
        update();
        super.onBackPressed();
    }

    public void nextChallenge() {
        String challenge_result = firebaseReceiver.nextChallenge();
        binding.text.setText(challenge_result);
        board.invalidate();
    }

    private void nextTheory() {
        String theory_result = firebaseReceiver.nextTheory(board);
        binding.text.setText(theory_result);
    }

    public BoardView getBoard() {
        return board;
    }

    public void updateTurn() {
//        StringBuilder sb = new StringBuilder();
//        String current = Game.players[Game.turns % Game.players.length].id;
//        for (Player p : Game.players) {
//            sb.append("<font color='")
//                    .append(String.format("#%06X", (0xFFFFFF & Game.getPlayerColor(p.id))))
//                    .append("'>");
//            if (p.id.equals(current)) sb.append("-> ");
//            if (Game.match_mode == Game.MODE_4_PLAYER_TEAMS) {
//                sb.append(p.name).append(" [").append(p.team).append("]</font><br />");
//            } else {
//                sb.append(p.name).append("</font><br />");
//            }
//        }
//        sb.delete(sb.lastIndexOf("<br />"), sb.length());
    }




}
