package com.example.chesswithme.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chesswithme.activities.MainActivity;
import com.example.chesswithme.databinding.FragmentLoginBinding;
import com.example.chesswithme.databinding.FragmentScrollBarBinding;

public class ScrollBarFragment extends Fragment {
    private FragmentScrollBarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScrollBarBinding.inflate(inflater, container, false);
        binding.lessons.setOnClickListener(view -> {

        });
        return binding.getRoot();
    }
}
