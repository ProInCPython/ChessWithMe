package com.example.chesswithme.fragments;

import static com.example.chesswithme.activities.AppActivity.current_user_reference;
import static com.example.chesswithme.activities.AppActivity.usersList;
import static com.example.chesswithme.activities.RegisterActivity.authController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chesswithme.R;
import com.example.chesswithme.activities.AppActivity;
import com.example.chesswithme.databinding.FragmentProfileBinding;
import com.example.chesswithme.firebase.ChessUserInfo;
import com.example.chesswithme.views.LeaderboardsItem;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    ChessUserInfo current_user = new ChessUserInfo();

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        dataInit();

        binding.changeUsername.setOnClickListener(view -> {
            binding.username.setVisibility(View.INVISIBLE);
            binding.editUsername.setVisibility(View.VISIBLE);
            binding.changeUsername.setOnClickListener(view2 -> {
                String new_username = binding.editUsername.getText().toString();
                ChessUserInfo updated_user = new ChessUserInfo();
                updated_user.setUsername(new_username);
                updated_user.setDailyPoints(current_user.getDailyPoints());
                updated_user.setWeeklyPoints(current_user.getWeeklyPoints());
                updated_user.setCompletedLessons(current_user.getCompletedLessons());
                updated_user.setMonthlyPoints(current_user.getMonthlyPoints());
                updated_user.setProfilePicture(current_user.getProfilePicture());
                updated_user.setEmail(current_user.getEmail());
                updated_user.setTop_three_finishes(current_user.getTop_three_finishes());
                updated_user.setPosition(current_user.getPosition());
                current_user_reference.removeValue();
                current_user_reference.setValue(updated_user);
                binding.editUsername.setVisibility(View.INVISIBLE);
                binding.username.setVisibility(View.VISIBLE);
            });
        });


    }

    public void dataInit() {
//        for (ChessUserInfo user : usersList) {
//            if(user.getEmail().equals(authController.getUser().getEmail())) {
//                current_user = user;
//            }
//        }
        binding.username.setVisibility(View.VISIBLE);
        binding.lessonsComplete.setVisibility(View.VISIBLE);
        binding.pointsScored.setVisibility(View.VISIBLE);
        binding.ratingPlace.setVisibility(View.VISIBLE);
        binding.topThreeFinishes.setVisibility(View.VISIBLE);
        binding.profilePictureProfileFragment.setVisibility(View.VISIBLE);
        for (ChessUserInfo user : usersList) {
            binding.editUsername.setHint(user.getUsername());
            binding.username.setText(user.getUsername());
            binding.lessonsComplete.setText(String.valueOf(user.getCompletedLessons()));
            binding.pointsScored.setText(String.valueOf(user.getMonthlyPoints()));
            binding.ratingPlace.setText(String.valueOf(user.getPosition()));
            binding.topThreeFinishes.setText(String.valueOf(user.getTop_three_finishes()));//String.valueOf(user.getTop_three_finishes())
            binding.profilePictureProfileFragment.setImageResource(R.drawable.user);
            if(user.getEmail().equals(authController.getUser().getEmail())) {

            }

        }

        binding.editUsername.setVisibility(View.INVISIBLE);
        binding.lessonsCompleteText.setText("Уроков пройдено");
        binding.pointsScoredText.setText("Очков набрано");
        binding.ratingPlaceText.setText("Место в рейтинге");
        binding.topThreeFinishesText.setText("Финишей в топ 3");


    }

}
