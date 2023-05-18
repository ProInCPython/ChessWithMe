package com.example.chesswithme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

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
        data.add(new LessonItem("1", "1", "Pawn", "Как ходят шахматные фигуры: пешка"));
        data.add(new LessonItem("2", "1", "King", "Как ходят шахматные фигуры: король"));
        data.add(new LessonItem("3", "1", "Bishop", "Как ходят шахматные фигуры: слон"));
        data.add(new LessonItem("4", "1", "Knight", "Как ходят шахматные фигуры: конь"));
        data.add(new LessonItem("5", "1", "Rook", "Как ходят шахматные фигуры: ладья"));
        data.add(new LessonItem("6", "1", "Queen", "Как ходят шахматные фигуры: ферзь"));
        data.add(new LessonItem("7", "1", "Summary", "Как ходят шахматные фигуры: обобщение"));
    }

}
