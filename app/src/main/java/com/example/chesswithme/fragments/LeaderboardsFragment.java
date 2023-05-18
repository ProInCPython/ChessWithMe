package com.example.chesswithme.fragments;

import static com.example.chesswithme.activities.AppActivity.usersList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chesswithme.App;
import com.example.chesswithme.R;
import com.example.chesswithme.adapters.LeaderboardsAdapter;
import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.controller.AuthController;
import com.example.chesswithme.databinding.FragmentLeaderboardsBinding;
import com.example.chesswithme.firebase.ChessUserInfo;
import com.example.chesswithme.views.LeaderboardsItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeaderboardsFragment extends Fragment {

    FragmentLeaderboardsBinding binding;
    AuthController authController = new AuthController();
    private List<LeaderboardsItem> data = new ArrayList<>();
    LeaderboardsAdapter adapter;

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
        data.clear();
        binding = FragmentLeaderboardsBinding.inflate(getLayoutInflater());
        binding.menuGroup.setText("Рейтинг за сегодня");
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter = new LeaderboardsAdapter(data);
        binding.recyclerView.setAdapter(adapter);
        setInitialData(1, 1);
        binding.menuGroup.setOnClickListener(viewClickListener);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateData(1, 1);
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }

    }

    View.OnClickListener viewClickListener = this::showPopupMenu;

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(binding.recyclerView.getContext(), v);
        popupMenu.inflate(R.menu.rating_type_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.daily_rating:
                        updateData(1, 2);
                        return true;
                    case R.id.monthly_rating:
                        updateData(3, 2);
                        return true;
                    case R.id.weekly_rating:
                        updateData(2, 2);
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {

            }
        });

        popupMenu.show();

    }



    private void updateData(int type, int number) {
        setInitialData(type, number);
    }

    private void setInitialData(int rating_type, int number){
        data.clear();
        if(number != 1) {
            data.clear();
            adapter = new LeaderboardsAdapter(data);
            binding.recyclerView.setAdapter(adapter);
        }
        switch (rating_type) { //1 - за сегодня, 2 - за неделю, 3 - за месяц
            case 1:
                for (ChessUserInfo user : usersList) {
                    data.add(new LeaderboardsItem ("", user.getUsername(), user.getDailyPoints(), user.getProfilePicture()));
                }
                binding.menuGroup.setText("Рейтинг за сегодня");
                break;
            case 2:
                for (ChessUserInfo user : usersList) {
                    data.add(new LeaderboardsItem ("", user.getUsername(), user.getWeeklyPoints(), user.getProfilePicture()));
                }
                binding.menuGroup.setText("Рейтинг за неделю");
                break;
            case 3:
                for (ChessUserInfo user : usersList) {
                    data.add(new LeaderboardsItem ("", user.getUsername(), user.getMonthlyPoints(), user.getProfilePicture()));
                }
                binding.menuGroup.setText("Рейтинг за месяц");
                break;

        }
        data.sort(new LeaderboardsItem.UsersComparator());
        if(number == 1) {
            number += 1;
            adapter = new LeaderboardsAdapter(data);
            binding.recyclerView.setAdapter(adapter);
        } else {
            adapter = new LeaderboardsAdapter(data);
            binding.recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
//        authController.getUser().getEmail();
//        data.add(new LeaderboardsItem ("1", "Кантабрики", "100xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("2", "Страннось","90xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("3", "Professional", "85xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("4", "ChessMaster", "67xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("5", "Круть", "55xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("6", "SamsungRules", "53xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("7", "Oh yeah","50xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("8", "Вот и я", "43xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("9", "Шахматно", "23xp", R.drawable.user));
//        data.add(new LeaderboardsItem ("10", "Слон и конь", "15xp", R.drawable.user));
    }

}
