package com.example.chesswithme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.chesswithme.R;

public class GameFragment extends Fragment {

    private TextView turn;
    private View board;

    public String currentMatch;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//        currentMatch = getArguments().getString("matchID");
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game, container, false);
//        board = v.findViewById(R.id.board);
//        Game.UI = this;
        updateTurn();
        return v;
    }

    public void update(boolean gameOver) {
        if (board == null) return;
        board.invalidate();
        if (!gameOver) updateTurn();
    }

    public void updateTurn() {
//        if (turn == null) return;
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
//        turn.setText(Html.fromHtml(sb.toString()));
    }


}
