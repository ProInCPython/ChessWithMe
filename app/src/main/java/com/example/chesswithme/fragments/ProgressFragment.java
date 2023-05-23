package com.example.chesswithme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chesswithme.R;
import com.example.chesswithme.databinding.FragmentProgressBinding;

public class ProgressFragment extends Fragment {

    FragmentProgressBinding binding;

    public ProgressFragment() {
        super(R.layout.fragment_progress);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentProgressBinding.inflate(getLayoutInflater());

    }
}
