package com.example.chesswithme.adapters;

import static com.example.chesswithme.activities.AppActivity.current_user_reference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chesswithme.R;
import com.example.chesswithme.firebase.ChessUserInfo;
import com.example.chesswithme.fragments.ProfileFragment;
import com.example.chesswithme.views.LeaderboardsItem;
import com.example.chesswithme.databinding.LeaderboardsItemBinding;

import java.util.List;

public class LeaderboardsAdapter extends RecyclerView.Adapter<LeaderboardsAdapter.ViewHolder> {
    private final List<LeaderboardsItem> data;

    public LeaderboardsAdapter(List<LeaderboardsItem> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboards_item, parent, false);
        LeaderboardsItemBinding binding = LeaderboardsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LeaderboardsItem state = data.get(position);
        holder.profile_picture.setImageResource(R.drawable.user);
        holder.username.setText(state.getUsername());
        state.setPosition(Integer.toString(holder.getAdapterPosition() + 1));
        holder.position.setText(state.getPosition());
        holder.points.setText(Integer.toString(state.getPoints()));
//        holder.item.setOnClickListener(view -> {
//            //go to person's profile
//        });
    }

    @Override
    public int getItemCount() {
        int a ;

        if(data != null && !data.isEmpty()) {
            a = data.size();
        }
        else {
            a = 0;
        }
        return a;
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
