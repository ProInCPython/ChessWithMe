package com.example.chesswithme.adapters;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private int clicked_items = 0;

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

        if(state.isTitle()) {
            holder.title_lesson.setVisibility(View.VISIBLE);
            switch (String.valueOf(state.getModule())) {
                case "1":
                    holder.description_module.setText("Как ходят шахматные фигуры");
                    holder.title_module.setText("Модуль первый");
            }
        } else {
            holder.proper_lesson.setVisibility(View.VISIBLE);
            holder.completed_lesson_cover.setVisibility(View.INVISIBLE);
            holder.locked_lesson_cover.setVisibility(View.INVISIBLE);

            holder.description_card.setVisibility(View.INVISIBLE);
            holder.symbol.setImageResource(state.picture_resource);
            holder.lesson_name.setText(state.getSimple_lesson_name());

            if(position >= state.getCompleted_lessons() + 1) {
                if(position == state.getCompleted_lessons() + 1) {
                    holder.symbol.setOnClickListener(view -> {
                        holder.description_card.setVisibility(View.VISIBLE);
                        TranslateAnimation animation = new TranslateAnimation(-40, 30, 0, 0);
                        animation.setDuration(500);
                        animation.setFillAfter(true);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                        alphaAnimation.setDuration(1000);
                        alphaAnimation.setFillAfter(true);
                        holder.description_card.startAnimation(alphaAnimation);
                        holder.description_card.startAnimation(animation);
                        holder.description_card.setAlpha(1);
                        holder.description_card.setBackgroundResource(R.color.card_color_lesson);
                        if(state.getPreviousClickedPosition() == -1) {
                            state.setClicked(true);
                            for (LessonItem item : data) {
                                item.setPreviousClickedPosition(position);
                            }
                        } else {
                            data.get(state.getPreviousClickedPosition()).setClicked(false);
                            state.setClicked(true);
                        }
                    });

                    holder.description_card.setOnClickListener(view -> {
                        state.setClicked(false);
                        Intent intent = new Intent(view.getContext(), LessonActivity.class);
                        intent.putExtra("simple_lesson_name", state.getSimple_lesson_name());
                        intent.putExtra("module", state.getModule());
                        intent.putExtra("database_lesson_name", state.getLesson_name());
                        holder.description_card.setVisibility(View.INVISIBLE);
                        holder.button.getContext().startActivity(intent);
                    });

                } else {
                    holder.locked_lesson_cover.setVisibility(View.VISIBLE);
                }
            } else {
                holder.completed_lesson_cover.setVisibility(View.VISIBLE);
            }
        }



        //


//        if(position < state.getCompleted_lessons()) {
//            holder.completed_lesson_cover.setVisibility(View.VISIBLE);
//        } else {
//            if(!state.isClicked()) {
//                holder.symbol.setOnClickListener(view -> {
//                    holder.description_card.setVisibility(View.VISIBLE);
//                    TranslateAnimation animation = new TranslateAnimation(-40, 30, 0, 0);
//                    animation.setDuration(1000);
//                    animation.setFillAfter(true);
//                    AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
//                    alphaAnimation.setDuration(1500);
//                    alphaAnimation.setFillAfter(true);
//                    holder.description_card.startAnimation(alphaAnimation);
//                    holder.description_card.startAnimation(animation);
//                    holder.description_card.setAlpha(1);
//                    holder.description_card.setBackgroundResource(R.color.card_color_lesson);
//                    if(state.getPreviousClickedPosition() == -1) {
//                        state.setClicked(true);
//                        for (LessonItem item : data) {
//                            item.setPreviousClickedPosition(position);
//                        }
//                    } else {
//                        data.get(state.getPreviousClickedPosition()).setClicked(false);
//                        state.setClicked(true);
//                    }
//                });
//            } else {
//                holder.description_card.setVisibility(View.INVISIBLE);
//                holder.description_card.setAlpha(0);
//            }
//
//
//
//
//        }

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
        final RelativeLayout completed_lesson_cover;
        final RelativeLayout locked_lesson_cover;
        final RelativeLayout proper_lesson;
        final RelativeLayout title_lesson;
        final TextView title_module;
        final TextView description_module;

        ViewHolder(View view){
            super(view);
            symbol = view.findViewById(R.id.symbol);
            button = view.findViewById(R.id.button);
            description_card = view.findViewById(R.id.description_card);
            lesson_name = view.findViewById(R.id.lesson_name_text);
            completed_lesson_cover = view.findViewById(R.id.completed_lesson_cover);
            locked_lesson_cover = view.findViewById(R.id.locked_lesson_cover);
            proper_lesson = view.findViewById(R.id.lesson_card_real);
            title_lesson = view.findViewById(R.id.lesson_card_title);
            title_module = view.findViewById(R.id.title_module);
            description_module = view.findViewById(R.id.description_module);
        }
    }
}
