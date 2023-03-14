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
import com.example.chesswithme.databinding.FragmentLeaderboardsBinding;
import com.example.chesswithme.views.LeaderboardsItem;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardsFragment extends Fragment {

    FragmentLeaderboardsBinding binding;
    private final List<LeaderboardsItem> data = new ArrayList<>();

    public LeaderboardsFragment() {
        super(R.layout.fragment_leaderboards);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLeaderboardsBinding.inflate(getLayoutInflater());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.recyclerView.setAdapter(new LeaderboardsAdapter(data));
        setInitialData();
        binding.recyclerView.setAdapter(new LeaderboardsAdapter(data));
    }

    private void setInitialData(){

        data.add(new LeaderboardsItem ("1", "Кантабрики", "100xp", R.drawable.user));
        data.add(new LeaderboardsItem ("2", "Страннось","90xp", R.drawable.user));
        data.add(new LeaderboardsItem ("3", "Professional", "85xp", R.drawable.user));
        data.add(new LeaderboardsItem ("4", "ChessMaster", "67xp", R.drawable.user));
        data.add(new LeaderboardsItem ("5", "Круть", "55xp", R.drawable.user));
        data.add(new LeaderboardsItem ("6", "SamsungRules", "53xp", R.drawable.user));
        data.add(new LeaderboardsItem ("7", "Oh yeah","50xp", R.drawable.user));
        data.add(new LeaderboardsItem ("8", "Вот и я", "43xp", R.drawable.user));
        data.add(new LeaderboardsItem ("9", "Шахматно", "23xp", R.drawable.user));
        data.add(new LeaderboardsItem ("10", "Слон и конь", "15xp", R.drawable.user));
    }

}
