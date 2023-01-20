package com.example.chesswithme.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.chesswithme.R;

public class Tile extends GameObject {

    private Bitmap toppipe;
    private Bitmap bottompipe;

    private static final float xSpeed = 10;
    private static final float spacerSize = 300;

    private float ySpacer;
    private final float height;
    private final float width;

    public Bitmap getToppipe() {
        return toppipe;
    }

    public Bitmap getBottompipe() {
        return bottompipe;
    }

    public Tile(Context context, float height, float width) {
        super(width, 0);
        this.height = height;
        this.width = width;
        toppipe = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe_rotated);
        bottompipe = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);
    }

    private void generatePipe() {
        y = random(height / 4f, height * 3 / 4f);

        toppipe = Bitmap.createScaledBitmap(toppipe, 200, (int) (y - spacerSize), false);
        bottompipe = Bitmap.createScaledBitmap(bottompipe, 200, (int) (height - y - spacerSize), false);
    }

    @Override
    public void update() {
        x -= xSpeed;
        if (x <= -bottompipe.getWidth()) {
            x = width;
            generatePipe();
        }
    }

    public boolean isCollision(GameObject object) {
        if (x - 50 < object.x && x + bottompipe.getWidth() > object.x) {
            if (object.y < toppipe.getHeight()) return true;
            return object.y - 10 > height - bottompipe.getHeight();
        }
        return false;
    }

    private float random(float min, float max) {
        return (float) (min + (Math.random() * (max - min)));
    }



}
