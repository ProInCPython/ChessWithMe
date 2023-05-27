package com.example.chesswithme.fragments;

import static com.example.chesswithme.activities.AppActivity.usersList;
import static com.example.chesswithme.activities.RegisterActivity.authController;

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
import com.example.chesswithme.adapters.LessonsAdapter;
import com.example.chesswithme.databinding.FragmentLessonsBinding;
import com.example.chesswithme.firebase.ChessUserInfo;
import com.example.chesswithme.views.LessonItem;

import java.util.ArrayList;
import java.util.List;

public class LessonsFragment extends Fragment {

    FragmentLessonsBinding binding;
    LessonsAdapter adapter;
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

//        binding.progressBar.setVisibility(View.VISIBLE);

        binding = FragmentLessonsBinding.inflate(getLayoutInflater());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter = new LessonsAdapter(data);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setInitialData();
        adapter = new LessonsAdapter(data);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
//        binding.progressBar.setVisibility(View.INVISIBLE);

    }



    private void setInitialData(){
        int completed_lessons = 0;
        for (ChessUserInfo user : usersList) {
            if(user.getEmail().equals(authController.getUser().getEmail())) {
                completed_lessons = user.getCompletedLessons();
            }
        }

        data.add(new LessonItem("1", "1", "Pawn", "Как ходят шахматные фигуры: пешка", R.drawable.pawn_white, false, -1, completed_lessons, true));
        data.add(new LessonItem("1", "1", "Pawn", "Как ходят шахматные фигуры: пешка", R.drawable.pawn_white, false, -1, completed_lessons, false));
        data.add(new LessonItem("2", "1", "King", "Как ходят шахматные фигуры: король", R.drawable.king_white, false, -1, completed_lessons,false));
        data.add(new LessonItem("3", "1", "Bishop", "Как ходят шахматные фигуры: слон", R.drawable.bishop_white, false, -1, completed_lessons,false));
        data.add(new LessonItem("4", "1", "Knight", "Как ходят шахматные фигуры: конь", R.drawable.knight_white, false, -1, completed_lessons,false));
        data.add(new LessonItem("5", "1", "Rook", "Как ходят шахматные фигуры: ладья", R.drawable.rook_white, false, -1, completed_lessons,false));
        data.add(new LessonItem("6", "1", "Queen", "Как ходят шахматные фигуры: ферзь", R.drawable.queen_white, false, -1, completed_lessons,false));
        data.add(new LessonItem("7", "1", "Summary", "Как ходят шахматные фигуры: обобщение", R.drawable.book, false, -1, completed_lessons,false));
    }

}
