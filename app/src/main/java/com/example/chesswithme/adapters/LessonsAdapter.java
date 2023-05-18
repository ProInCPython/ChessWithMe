package com.example.chesswithme.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chesswithme.R;
import com.example.chesswithme.activities.LessonActivity;
import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.databinding.LessonItemBinding;
import com.example.chesswithme.views.LessonButton;
import com.example.chesswithme.views.LessonItem;

import org.w3c.dom.Text;

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
        holder.description_card.setAlpha(0);
        holder.description_card.setVisibility(View.GONE);
        switch (position) {
            case 0:
                holder.symbol.setImageResource(R.drawable.pawn_white);
                break;
            case 1:
                holder.symbol.setImageResource(R.drawable.king_white);
                break;
            case 2:
                holder.symbol.setImageResource(R.drawable.bishop_white);
                break;
            case 3:
                holder.symbol.setImageResource(R.drawable.knight_white);
                break;
            case 4:
                holder.symbol.setImageResource(R.drawable.rook_white);
                break;
            case 5:
                holder.symbol.setImageResource(R.drawable.queen_white);
                break;
            case 6:
                holder.symbol.setImageResource(R.drawable.podium);
                break;
        }
        holder.lesson_name.setText(state.getSimple_lesson_name());
        holder.symbol.setOnClickListener(view -> {
            holder.description_card.setVisibility(View.VISIBLE);
            TranslateAnimation animation = new TranslateAnimation(0, 40, 0, 0);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setDuration(1000);
            alphaAnimation.setFillAfter(true);
            holder.description_card.startAnimation(animation);
            holder.description_card.startAnimation(alphaAnimation);

        });

        holder.description_card.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), LessonActivity.class);
            intent.putExtra("simple_lesson_name", state.getSimple_lesson_name());
            intent.putExtra("module", state.getModule());
            intent.putExtra("database_lesson_name", state.getLesson_name());
            holder.button.getContext().startActivity(intent);
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
        final ImageView symbol;
        final CardView description_card;
        final TextView lesson_name;

        ViewHolder(View view){
            super(view);
            symbol = view.findViewById(R.id.symbol);
            button = view.findViewById(R.id.button);
            description_card = view.findViewById(R.id.description_card);
            lesson_name = view.findViewById(R.id.lesson_name_text);
        }
    }
}
