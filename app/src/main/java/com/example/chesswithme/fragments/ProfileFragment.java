package com.example.chesswithme.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chesswithme.R;
import com.example.chesswithme.activities.AppActivity;
import com.example.chesswithme.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private static final int REQUEST_TAKE_PHOTO = 1;
    ImageView photo;
    FragmentProfileBinding binding;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        dataInit();

        binding.changePhoto.setOnClickListener(view -> {
            Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try{
                startActivityForResult(takePhotoIntent, REQUEST_TAKE_PHOTO);
            }catch (ActivityNotFoundException e){
                e.printStackTrace();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем миниатюру картинки
            Bundle extras = data.getExtras();
            Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
            binding.profilePictureProfileFragment.setImageBitmap(thumbnailBitmap);
        }
    }

    public void dataInit() {
        binding.username.setText("ChessPro");
        binding.joinDate.setText("Присоединился в феврале 2023");
        binding.lessonsComplete.setText("30");
        binding.lessonsCompleteText.setText("Уроков пройдено");
        binding.pointsScored.setText("5468");
        binding.pointsScoredText.setText("Очков набрано");
        binding.ratingPlaceText.setText("Место в рейтинге");
        binding.ratingPlace.setText("5");
        binding.topThreeFinishesText.setText("Финишей в топ 3");
        binding.topThreeFinishes.setText("6");
        binding.achievementImage.setImageResource(R.drawable.podium);
        binding.achievementDescription.setText("Пройти 1 урок");
        binding.achievementName.setText("Начинающий шахматист");
    }

}
