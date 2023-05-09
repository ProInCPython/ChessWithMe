package com.example.chesswithme.activities;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.App;
import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.chessboard2.BoardView;
import com.example.chesswithme.chessboard2.Coordinate;
import com.example.chesswithme.databinding.ActivityLessonBinding;
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
    private BoardView board;
    DatabaseReference databaseReference;
    String data;
    LessonObject lesson;
    private String finish_conditions;
    private String initial_position;
    private int theory_index = 0;
    private int description_index = 0;
    private int position_index = 0;
    private ArrayList<String> description;
    private ArrayList<String> theory;
    private ArrayList<LessonObject> challenges;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        board = binding.board;
        databaseReference = App.getDatabaseReference("AppData").child("Modules");
        binding.button.setAlpha(0);
        binding.button2.setAlpha(0);
        binding.send.setAlpha(0);
        binding.newGame.setAlpha(0);
        binding.challengeNumber.setAlpha(0);
        binding.moduleNumber.setAlpha(0);
        binding.userColor.setAlpha(0);
        binding.lessonName.setAlpha(0);

        ValueEventListener lessonListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                boolean flag = false;
//                for (DataSnapshot lessonSnapshot : dataSnapshot.getChildren()) {
//                    if(lessonSnapshot.hasChild("userColor")) {
//                        lesson = lessonSnapshot.getValue(LessonObject.class);
//                        flag = true;
//                    }
//
////                    lesson.setInitial_position(lessonSnapshot.child("initial_position").getValue(String.class));
////                    lesson.setFinish_conditions(lessonSnapshot.child("finish_conditions").getValue(String.class));
////                    lesson.setUserColor(lessonSnapshot.child("userColor").getValue(String.class));
//                }
//                if (!flag) {
//                    lesson = new LessonObject();
//                    lesson.setUserColor("white");
//                    lesson.setFinish_conditions("Queen on the board");
//                    lesson.setInitial_position("0,0,white,Rook;0,1,white,Pawn;0,6,black,Pawn;0,7,black,Rook;1,0,white,Knight;1,1,white,Pawn;1,6,black,Pawn;1,7,black,Knight;2,0,white,Bishop;2,1,white,Pawn;2,6,black,Pawn;2,7,black,Bishop;3,0,white,King;3,3,white,Pawn;3,6,black,Pawn;3,7,black,King;4,0,white,Queen;4,1,white,Pawn;4,4,black,Pawn;4,7,black,Queen;5,0,white,Bishop;5,1,white,Pawn;5,6,black,Pawn;5,7,black,Bishop;6,0,white,Knight;6,1,white,Pawn;6,6,black,Pawn;6,7,black,Knight;7,0,white,Rook;7,1,white,Pawn;7,6,black,Pawn;7,7,black,Rook;");
//
//                }
                lesson = dataSnapshot.child("1").getValue(LessonObject.class);
                initial_position = dataSnapshot.child("init_pos_theory").getValue(InitialPosition.class).getValue();
                GenericTypeIndicator<ArrayList<String>> description_init = new GenericTypeIndicator<ArrayList<String>>() {
                };
                description = dataSnapshot.child("description").getValue(description_init);
                GenericTypeIndicator<ArrayList<String>> theory_init = new GenericTypeIndicator<ArrayList<String>>() {
                };
                theory = dataSnapshot.child("theory").getValue(theory_init);
//                challenges.add(lesson);

                Board.load(initial_position, "white");
                nextTheory(theory, 0);
                theory_index += 1;
                board.invalidate();
                BoardView.userColor = Board.userColor;
//                for (DataSnapshot lessonSnapshot : dataSnapshot.getChildren()) {
////                    if (lessonSnapshot.getKey().equals("1")) {
////                        for (DataSnapshot newLessonSnapshot : lessonSnapshot.getChildren()) {
////                            LessonObject lesson = newLessonSnapshot.getValue(LessonObject.class);
////                            challenges.add(lesson);
////                        }
////                    }
////                    Map<String, String> map = (Map<String, String>) lessonSnapshot.getValue();
//
//
//                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };



        App.getDatabaseReference("AppData").child("Modules").child("1").child("Pawn").addValueEventListener(lessonListener);
//        Board.newGame();
//        BoardView.userColor = Board.userColor;
//        binding.text.setText("Привет! В этом уроке мы поговорим о том, как ходит пешка. Посмотри на доску.");


        //ON CLICK LISTENERS

        binding.button.setOnClickListener(view -> {
            data = Board.getString();
//            binding.text.setText(data);
        });
        binding.button2.setOnClickListener(view -> {
            if (data != null) {
//                Board.load(data, "white");
            }
        });
        binding.send.setOnClickListener(view -> {
            if (data != null) {
                String module_number = binding.moduleNumber.getText().toString();
                String lesson_name = binding.lessonName.getText().toString();
                String challenge_number = binding.challengeNumber.getText().toString();
                String userColor = binding.userColor.getText().toString();
                ArrayList<String> array = new ArrayList<>();
                array.add("В этом задании тебе нужно провести одну из своих пешек в ферзи!");
                array.add("Прекрасная работа!");
                ArrayList<String> array2 = new ArrayList<>();
                array2.add("В этом уроке мы поговорим о пешке!");
                array2.add("Теперь перейдем к практике!");

                LessonObject lessonObject = new LessonObject();
                //data, array, "Queen on the board", userColor
                lessonObject.setInitial_position(data);
                lessonObject.setFinish_conditions("Queen on the board");
                lessonObject.setUserColor(userColor);

                InitialPosition init = new InitialPosition();
                init.setValue(data);


                databaseReference.child(module_number).child(lesson_name).child(challenge_number).setValue(lessonObject);
                databaseReference.child(module_number).child(lesson_name).child("description").setValue(array);
                databaseReference.child(module_number).child(lesson_name).child("theory").setValue(array2);
                databaseReference.child(module_number).child(lesson_name).child("init_pos_theory").setValue(init);
            }
        });

        binding.newGame.setOnClickListener(view -> {
            Board.newGame();
        });

        binding.scrollText.setOnClickListener(view -> {
            if(theory.size() == theory_index) {
                nextChallenge(description, description_index, challenges, position_index);
            } else {
                nextTheory(theory, theory_index);
                theory_index += 1;
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

    private boolean nextChallenge(ArrayList<String> description, int next_desc_index, ArrayList<LessonObject> challenges, int next_position) {
        if(challenges.size() == next_position) {
            return false;
        } else {
            LessonObject lesson = challenges.get(next_position);
            String userColor = lesson.getUserColor();
            String initial_position = lesson.getInitial_position();
            finish_conditions = lesson.getFinish_conditions();
            BoardView.userColor = userColor;
            binding.text.setText(description.get(next_desc_index));
            Board.load(initial_position, userColor);
            board.invalidate();
            return true;
        }
    }

    private void nextTheory(ArrayList<String> theory, int next_theory_index) {
        binding.text.setText(theory.get(next_theory_index));
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
