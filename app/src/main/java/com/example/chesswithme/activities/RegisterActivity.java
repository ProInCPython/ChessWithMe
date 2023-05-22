package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.App;
import com.example.chesswithme.R;
import com.example.chesswithme.controller.AuthController;
import com.example.chesswithme.databinding.ActivityRegisterBinding;
import com.example.chesswithme.firebase.ChessUserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    DatabaseReference databaseReference;
    public final static AuthController authController = new AuthController();
    ChessUserInfo chessUserInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = App.getDatabaseReference().child("Users");

        binding.button.setOnClickListener(view -> {

                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
                String repeat_password = binding.repeatPassword.getText().toString();
                String username = binding.username.getText().toString();

            if(password.equals(repeat_password)) {
                authController.registerUser(email, password, task -> {
                    if (task.isSuccessful()) {
                        addUserDatatoFirebase(email, username, 0, 0, 0, 0, R.drawable.user, 0, 0, 0, 1, 0);
                        startActivity(new Intent(this, AppActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                binding.passwordsNotMatch.setText("Пароли не совпадают!");
            }


        });

        binding.alreadyHave.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });


//        UserDAO userDAO = App.getDatabase().userDAO();

//        binding.button.setOnClickListener(view -> {
//
//            if(password.equals(repeat_password)) {
//
//                    Date currentDate = new Date();
//                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
//                    String join_date = dateFormat.format(currentDate);
////                    UserEntity user = new UserEntity(email, password.hashCode(), join_date);
//
//                    new Thread(() -> {
//                        if(userDAO.getPassword(password.hashCode()) == null) {
//                            userDAO.insert(user);
//                        } else {
//                            runOnUiThread(() -> {
//                                binding.passwordsNotMatch.setText("Пользователь с таким паролем уже существует!");
//                            });
//                        }
//                    }).start();
//
//                    runOnUiThread(() -> {
//                        binding.passwordsNotMatch.setText("");
//                        Intent intent = new Intent(this, LoginActivity.class);
//                        startActivity(intent);
//                    });
//
//            } else {
//                binding.passwordsNotMatch.setText("Пароли не совпадают!");
//            }
//
//        }
//        );



    }

    private void addUserDatatoFirebase(String email, String username, int dailyPoints, int weeklyPoints, int monthlyPoints, int completedLessons, int profilePicture, int position, int top_three_finishes, int goldenPawns, int level, int alltimePoints) {
        chessUserInfo = new ChessUserInfo();
        chessUserInfo.setUsername(username);
        chessUserInfo.setDailyPoints(dailyPoints);
        chessUserInfo.setWeeklyPoints(weeklyPoints);
        chessUserInfo.setCompletedLessons(completedLessons);
        chessUserInfo.setMonthlyPoints(monthlyPoints);
        chessUserInfo.setProfilePicture(profilePicture);
        chessUserInfo.setEmail(email);
        chessUserInfo.setTop_three_finishes(top_three_finishes);
        chessUserInfo.setPosition(position);
        chessUserInfo.setGoldenPawns(goldenPawns);
        chessUserInfo.setLevel(level);
        chessUserInfo.setAllTimePoints(alltimePoints);
        databaseReference.push().setValue(chessUserInfo);

        // we are use add value event listener method
        // which is called with database reference.
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // inside the method of on Data change we are setting
//                // our object class to our database reference.
//                // data base reference will sends data to firebase.
//                //mDatabase.child("users").child(userId).setValue(user);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // if the data is not added or it is cancelled then
//                // we are displaying a failure toast message.
//                Toast.makeText(RegisterActivity.this, "Что-то пошло не так... " + error, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}
