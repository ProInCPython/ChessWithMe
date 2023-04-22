package com.example.chesswithme.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chesswithme.R;
import com.example.chesswithme.activities.LessonActivity;
import com.example.chesswithme.databinding.LessonItemBinding;
import com.example.chesswithme.views.LessonButton;
import com.example.chesswithme.views.LessonItem;

import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.ViewHolder>{
    private final List<LessonItem> data;

    public LessonsAdapter(List<LessonItem> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public LessonsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboards_item, parent, false);
        LessonItemBinding binding = LessonItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LessonItem state = data.get(position);
        holder.symbol.setText(state.getText());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LessonActivity.class);
                holder.button.getContext().startActivity(intent);
            }
        });
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
        final CardView button;
        final Button symbol;
        ViewHolder(View view){
            super(view);
            symbol = view.findViewById(R.id.symbol);
            button = view.findViewById(R.id.button);
        }
    }
}
