package com.example.chesswithme.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.R;
import com.example.chesswithme.fragments.LeaderboardsFragment;
import com.example.chesswithme.fragments.LessonsFragment;
import com.example.chesswithme.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, LessonsFragment.class, null)
                    .commit();
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.scroll_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.lessons:
                        if (savedInstanceState == null) {
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.fragment_container_view, LessonsFragment.class, null)
                                    .commit();
                        }
                        break;
                    case R.id.leaderboards:
                        if (savedInstanceState == null) {
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.fragment_container_view, LeaderboardsFragment.class, null)
                                    .commit();
                        }
                        break;
                    case R.id.profile:
                        if (savedInstanceState == null) {
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.fragment_container_view, ProfileFragment.class, null)
                                    .commit();
                        }
                        break;
                }
                return true;
            }
        });

    }
}
