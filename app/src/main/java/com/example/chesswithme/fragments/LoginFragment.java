package com.example.chesswithme.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chesswithme.activities.AppActivity;
import com.example.chesswithme.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.buttonEnter.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), AppActivity.class);
            startActivity(intent);
        });
        return binding.getRoot();
    }
}
