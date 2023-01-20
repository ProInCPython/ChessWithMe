package com.example.chesswithme.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.chesswithme.R;

public class Bird extends GameObject {

    private Bitmap sprite;
    private float speed = 0;
    private static final float ACCELERATION = 9f;

    private final Bitmap up;
    private final Bitmap straight;
    private final Bitmap down;

    public Bitmap getSprite() {
        return sprite;
    }

    public Bird(Context context, float x, float y) {
        super(x, y);

        up = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird3);
        straight = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird2);
        down = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird1);
        sprite = straight;

    }

    public void fly() {
        speed = -70;
    }

    public void update() {
        y += speed;
        speed += ACCELERATION;
        if (speed < -20) sprite = down;
        else if (speed > 20) sprite = up;
        else sprite = straight;

    }

}
