package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.App;
import com.example.chesswithme.database.User;
import com.example.chesswithme.database.room.UserDAO;
import com.example.chesswithme.database.room.UserEntity;
import com.example.chesswithme.databinding.ActivityLoginBinding;
import com.example.chesswithme.databinding.ActivityRegisterBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String password = binding.password.getText().toString();
        String email = binding.email.getText().toString();

        UserDAO userDAO = App.getDatabase().userDAO();


        binding.button.setOnClickListener(view -> {

            new Thread(() -> {
                UserEntity user = userDAO.getPassword(password.hashCode());
                runOnUiThread(() -> {
                    if(user.password == password.hashCode()) {
                        if (user.email.equals(email)) {
                            Intent intent = new Intent(this, AppActivity.class);
                            binding.wrongPassword.setText("");
                            startActivity(intent);
                        } else {
                            binding.wrongPassword.setText("Введён неверный email или пароль!");
                        }
                    } else {
                        binding.wrongPassword.setText("Введён неверный email или пароль!");
                    }
                });

            }).start();
        }
        );

        binding.noAccount.setOnClickListener(view -> {
                        Intent intent = new Intent(this, RegisterActivity.class);
                        startActivity(intent);

                }
        );

    }

}
