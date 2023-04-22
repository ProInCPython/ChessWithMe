package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.App;
import com.example.chesswithme.controller.AuthController;
import com.example.chesswithme.database.room.UserDAO;
import com.example.chesswithme.database.room.UserEntity;
import com.example.chesswithme.databinding.ActivityRegisterBinding;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AuthController controller = new AuthController();

        binding.button.setOnClickListener(view -> {

                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
                String repeat_password = binding.repeatPassword.getText().toString();
            if(password.equals(repeat_password)) {
                controller.registerUser(email, password, task -> {
                    if (task.isSuccessful()) {
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

}
