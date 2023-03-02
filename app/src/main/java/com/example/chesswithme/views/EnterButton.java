package com.example.chesswithme.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chesswithme.R;
import com.example.chesswithme.databinding.EnterButtonBinding;

public class EnterButton extends FrameLayout {

     EnterButtonBinding binding;

    public EnterButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public EnterButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        binding = EnterButtonBinding.inflate(LayoutInflater.from(getContext()), this, true);

        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ActionButton, 0, 0);
        try {
            String text = attributes.getString(R.styleable.ActionButton_android_text);
            boolean textAlwaysCaps = attributes.getBoolean(R.styleable.ActionButton_android_textAllCaps, true);
            binding.getRoot().setText(text);
            binding.getRoot().setAllCaps(textAlwaysCaps);
        } finally {
            attributes.recycle();
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        binding.getRoot().setOnClickListener(l);
    }
}
