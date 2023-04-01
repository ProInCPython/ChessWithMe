package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.App;
import com.example.chesswithme.database.room.UserDAO;
import com.example.chesswithme.database.room.UserEntity;
import com.example.chesswithme.databinding.ActivityRegisterBinding;

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
        String email = binding.email.getText().toString();
        String password = binding.password.getText().toString();
        String repeat_password = binding.repeatPassword.getText().toString();
        UserDAO userDAO = App.getDatabase().userDAO();

        binding.button.setOnClickListener(view -> {

            if(password.equals(repeat_password)) {

                    Date currentDate = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                    String join_date = dateFormat.format(currentDate);
                    UserEntity user = new UserEntity(email, password.hashCode(), join_date);

                    new Thread(() -> {
                        if(userDAO.getPassword(password.hashCode()) == null) {
                            userDAO.insert(user);
                        } else {
                            runOnUiThread(() -> {
                                binding.passwordsNotMatch.setText("Пользователь с таким паролем уже существует!");
                            });
                        }
                    }).start();

                    runOnUiThread(() -> {
                        binding.passwordsNotMatch.setText("");
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                    });

            } else {
                binding.passwordsNotMatch.setText("Пароли не совпадают!");
            }

        }
        );



    }

}
