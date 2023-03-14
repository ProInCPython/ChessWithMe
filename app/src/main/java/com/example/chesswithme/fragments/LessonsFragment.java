package com.example.chesswithme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chesswithme.R;
import com.example.chesswithme.adapters.LeaderboardsAdapter;
import com.example.chesswithme.adapters.LessonsAdapter;
import com.example.chesswithme.databinding.FragmentLeaderboardsBinding;
import com.example.chesswithme.databinding.FragmentLessonsBinding;
import com.example.chesswithme.views.LeaderboardsItem;
import com.example.chesswithme.views.LessonButton;
import com.example.chesswithme.views.LessonItem;

import java.util.ArrayList;
import java.util.List;

public class LessonsFragment extends Fragment {

    FragmentLessonsBinding binding;
    private final List<LessonItem> data = new ArrayList<>();

    public LessonsFragment() {
        super(R.layout.fragment_lessons);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentLessonsBinding.inflate(getLayoutInflater());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.recyclerView.setAdapter(new LessonsAdapter(data));
        setInitialData();
        binding.recyclerView.setAdapter(new LessonsAdapter(data));
    }

    private void setInitialData(){
        data.add(new LessonItem("1"));
        data.add(new LessonItem("2"));
        data.add(new LessonItem("3"));
        data.add(new LessonItem("4"));
        data.add(new LessonItem("5"));
        data.add(new LessonItem("6"));
        data.add(new LessonItem("7"));
        data.add(new LessonItem("8"));
        data.add(new LessonItem("9"));
    }

}
