package com.example.chesswithme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chesswithme.R;
import com.example.chesswithme.views.LeaderboardsItem;

import java.util.List;

public class LeaderboardsAdapter extends RecyclerView.Adapter<LeaderboardsAdapter.ViewHolder> {
    private final List<LeaderboardsItem> data;

    public LeaderboardsAdapter(List<LeaderboardsItem> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboards_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LeaderboardsItem state = data.get(position);
        holder.profile_picture.setImageResource(state.getProfile_picture_resource());
        holder.username.setText(state.getUsername());
        holder.position.setText(state.getPosition());
        holder.points.setText(state.getPoints());
        holder.item.setOnClickListener(view -> {
            //go to person's profile
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView profile_picture;
        final TextView username, points, position;
        final RelativeLayout item;
        ViewHolder(View view){
            super(view);
            profile_picture = view.findViewById(R.id.profile_picture);
            username = view.findViewById(R.id.username);
            points = view.findViewById(R.id.points);
            position = view.findViewById(R.id.position);
            item = view.findViewById(R.id.item);
        }
    }
}
