package com.example.chesswithme.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLeaderboardsBinding.inflate(getLayoutInflater());
        setInitialData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );
        binding.recyclerView.setAdapter(new LeaderboardsAdapter(data));
    }

    private void setInitialData(){

        data.add(new LeaderboardsItem ("1", "Фурфифка", "100xp", R.drawable.user));
        data.add(new LeaderboardsItem ("2", "Страннось","90xp", R.drawable.user));
        data.add(new LeaderboardsItem ("3", "Professional", "85xp", R.drawable.user));
        data.add(new LeaderboardsItem ("4", "ChessMaster", "67xp", R.drawable.user));
        data.add(new LeaderboardsItem ("5", "GOOOO", "15xp", R.drawable.user));
    }

}
