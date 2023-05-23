package com.example.chesswithme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.controller.AuthController;
import com.example.chesswithme.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AuthController authController = new AuthController();

        binding.button.setOnClickListener(view -> {

            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();
            authController.signIn(email, password, task -> {
                if (task.isSuccessful()) {
                    startActivity(new Intent(this, AppActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        });

//        UserDAO userDAO = App.getDatabase().userDAO();
//
//
//        binding.button.setOnClickListener(view -> {
//
//            new Thread(() -> {
//                UserEntity user = userDAO.getPassword(password.hashCode());
//                runOnUiThread(() -> {
//                    if(user.password == password.hashCode()) {
//                        if (user.email.equals(email)) {
//                            Intent intent = new Intent(this, AppActivity.class);
//                            binding.wrongPassword.setText("");
//                            startActivity(intent);
//                        } else {
//                            binding.wrongPassword.setText("Введён неверный email или пароль!");
//                        }
//                    } else {
//                        binding.wrongPassword.setText("Введён неверный email или пароль!");
//                    }
//                });
//
//            }).start();
//        }
//        );

        binding.noAccount.setOnClickListener(view -> {
                    Intent intent = new Intent(this, RegisterActivity.class);
                    startActivity(intent);

                }
        );

    }

}
