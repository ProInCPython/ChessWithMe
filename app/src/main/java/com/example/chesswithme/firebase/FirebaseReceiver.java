package com.example.chesswithme.firebase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.example.chesswithme.App;
import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.chessboard2.BoardView;
import com.example.chesswithme.chessboard2.Coordinate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseReceiver {
    public static Board board = new Board();
    DatabaseReference databaseReference = App.getDatabaseReference();
    String data;
    LessonObject lesson;
    public boolean isDataReady = false;
    private String theory_initial_position;
    public boolean isEndLesson = false;
    private int theory_index = 0;
    private int description_index = 0;
    private int position_index = 0;
    private String finish_conditions;
    private ArrayList<String> description;
    private ArrayList<String> theory;
    private ArrayList<LessonObject> challenges = new ArrayList<>();
    ArrayList<ChessUserInfo> users = new ArrayList<>();

    public FirebaseReceiver() {
    }

    public boolean receiveData(String path, BoardView boardView) {
        ValueEventListener lessonListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lesson = dataSnapshot.child("1").getValue(LessonObject.class);
                theory_initial_position = dataSnapshot.child("init_pos_theory").getValue(InitialPosition.class).getValue();
                GenericTypeIndicator<ArrayList<String>> description_init = new GenericTypeIndicator<ArrayList<String>>() {
                };
                description = dataSnapshot.child("description").getValue(description_init);
                GenericTypeIndicator<ArrayList<String>> theory_init = new GenericTypeIndicator<ArrayList<String>>() {
                };
                theory = dataSnapshot.child("theory").getValue(theory_init);
                challenges.add(lesson);
                board.load(theory_initial_position, "white", "theory");
                BoardView.userColor = Board.userColor;
                boardView.invalidate();
                nextTheory(boardView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        String[] path_data = path.split("/");
        getPath(path_data, 0, databaseReference).addValueEventListener(lessonListener);
        return true;
    }

    public ArrayList<ChessUserInfo> receiveUsersData() {
        ValueEventListener usersListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    users.add(userSnapshot.getValue(ChessUserInfo.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        databaseReference.child("Users").addValueEventListener(usersListener);
        return users;
    }



    private DatabaseReference getPath(String[] data, int counter, DatabaseReference reference) {
        if(counter == data.length) {
            return reference;
        }
        return getPath(data, counter + 1, reference.child(data[counter]));
    }

    public String nextTheory(ArrayList<String> theory, BoardView boardView) {
        if(!theory.get(theory_index).equals(" ")) {
            String[] split_theory = theory.get(theory_index).split("//");
            if(!split_theory[1].equals("null")) {
                String updated_position = split_theory[1];
                boardView.setSelection(new Coordinate(updated_position.split(",")[0], updated_position.split(",")[1]));//split_theory[2].split(",")[0], split_theory[2].split(",")[1])
                board.load(updated_position, "white", "theory");
                boardView.invalidate();
            }
        }
        theory_index += 1;
        return theory.get(theory_index - 1);

    }

    public String nextTheory(BoardView boardView) {
        return nextTheory(theory, boardView);
    }

    public String nextChallenge(ArrayList<String> description, int next_desc_index, ArrayList<LessonObject> challenges, int next_position) {
        if(challenges.size() == next_position) {
            isEndLesson = true;
            return "lessonEnd";
        } else {
            LessonObject lesson = challenges.get(next_position);
            String userColor = lesson.getUserColor();
            String initial_position = lesson.getInitial_position();
            finish_conditions = lesson.getFinish_conditions();
            BoardView.userColor = userColor;
            board.load(initial_position, userColor, "challenge");
            description_index += 1;
            position_index += 1;
            return description.get(next_desc_index);
        }
    }

    public String nextChallenge() {
        return nextChallenge(description, description_index, challenges, position_index);
    }

    //GETTERS AND SETTERS


    public boolean isEndLesson() {
        return isEndLesson;
    }

    public void setEndLesson(boolean endLesson) {
        isEndLesson = endLesson;
    }

    public Board getBoard() {
        return board;
    }

    public String getTheory_initial_position() {
        return theory_initial_position;
    }

    public int getTheory_index() {
        return theory_index;
    }

    public int getDescription_index() {
        return description_index;
    }

    public int getPosition_index() {
        return position_index;
    }

    public String getFinish_conditions() {
        return finish_conditions;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public ArrayList<String> getTheory() {
        return theory;
    }

    public ArrayList<LessonObject> getChallenges() {
        return challenges;
    }

    public void setTheory_initial_position(String theory_initial_position) {
        this.theory_initial_position = theory_initial_position;
    }

    public void setTheory_index(int theory_index) {
        this.theory_index = theory_index;
    }

    public void setDescription_index(int description_index) {
        this.description_index = description_index;
    }

    public void setPosition_index(int position_index) {
        this.position_index = position_index;
    }

    public void setFinish_conditions(String finish_conditions) {
        this.finish_conditions = finish_conditions;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public void setTheory(ArrayList<String> theory) {
        this.theory = theory;
    }

    public void setChallenges(ArrayList<LessonObject> challenges) {
        this.challenges = challenges;
    }
}
