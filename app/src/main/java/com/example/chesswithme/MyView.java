package com.example.chesswithme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {

    private final Paint paint = new Paint();
    private final Bitmap someBird;
    private int currentColor = 0;

    public MyView(Context context) {
        super(context);
        someBird = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_background);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        switch(currentColor) {
            case 0:
                canvas.drawColor(Color.DKGRAY);
                break;
            case 1:
                canvas.drawColor(Color.LTGRAY);
                break;
            default:
                canvas.drawColor(Color.YELLOW);
        }

        for(Pair<Float, Float> coordinate : coordinates) {
            canvas.drawBitmap(someBird, coordinate.first, coordinate.second, null);
        }

        drawStuff(canvas);
        super.onDraw(canvas);
    }

    private final List<Pair<Float, Float>> coordinates = new ArrayList<>();


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentColor = (currentColor + 1) % 3;
        coordinates.add(new Pair<>(event.getX(), event.getY()));
        invalidate();
        return super.onTouchEvent(event);
    }

    private void drawStuff(Canvas canvas) {
        float rotateCenterX = 200;
        float rotateCenterY = 400;
        float rotateAngle = 45;
        canvas.rotate(rotateAngle, rotateCenterX, rotateCenterY);

        paint.setColor(Color.DKGRAY);
        paint.setTextSize(50);
        canvas.drawText("Слава булочке!", 0, 0, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(50, 500, 600, 800, paint);
        paint.setColor(Color.GREEN);
        paint.setAlpha(205);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(200,200,180, paint);
    }

}
