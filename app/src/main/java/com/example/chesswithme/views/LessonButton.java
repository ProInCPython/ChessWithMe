package com.example.chesswithme.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chesswithme.R;
import com.example.chesswithme.databinding.LessonButtonBinding;

public class LessonButton extends FrameLayout {

    LessonButtonBinding binding;

    public LessonButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public LessonButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        binding = LessonButtonBinding.inflate(LayoutInflater.from(getContext()), this, true);

        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.LessonButtonStyle, 0, 0);
        try {
            String text = attributes.getString(R.styleable.LessonButtonStyle_text);
            binding.getRoot().setText(text);
        } finally {
            attributes.recycle();
        }

    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        binding.getRoot().setOnClickListener(l);
    }

}
