package com.example.chesswithme.activities;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chesswithme.R;
import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.chessboard2.BoardView;
import com.example.chesswithme.chessboard2.Game;
import com.example.chesswithme.chessboard2.Player;
import com.example.chesswithme.databinding.ActivityLessonBinding;
import com.example.chesswithme.fragments.GameFragment;
import com.example.chesswithme.fragments.LessonsFragment;

public class LessonActivity extends AppCompatActivity {
    ActivityLessonBinding binding;
    private BoardView board;
    String data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        board = binding.board;
        Board.newGame();
        binding.button.setOnClickListener(view -> {
            data = Board.getString();
            binding.text.setText(data);
        });
        binding.button2.setOnClickListener(view -> {
            if(data != null) {
                Board.load(data);
            }
        });

        binding.text.setText("Привет! В этом уроке мы поговорим о том, как ходит ладья. Посмотри на доску. Ты видишь ладью?");
    }

    public void update() {
        if (board == null) return;
        board.invalidate();
    }

    @Override
    public void onBackPressed() {
        update();
        super.onBackPressed();
    }

    public void updateTurn() {
//        StringBuilder sb = new StringBuilder();
//        String current = Game.players[Game.turns % Game.players.length].id;
//        for (Player p : Game.players) {
//            sb.append("<font color='")
//                    .append(String.format("#%06X", (0xFFFFFF & Game.getPlayerColor(p.id))))
//                    .append("'>");
//            if (p.id.equals(current)) sb.append("-> ");
//            if (Game.match_mode == Game.MODE_4_PLAYER_TEAMS) {
//                sb.append(p.name).append(" [").append(p.team).append("]</font><br />");
//            } else {
//                sb.append(p.name).append("</font><br />");
//            }
//        }
//        sb.delete(sb.lastIndexOf("<br />"), sb.length());
    }



}
