package com.example.chesswithme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private Thread thread;
    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new Thread(new DrawThread());
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        holder = surfaceHolder;
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    class DrawThread implements Runnable {
        private volatile boolean running = true;
        boolean isYellow = false;

        @Override
        public void run() {
            while(running) {
                try {
                    Thread.sleep(1000);
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawColor(isYellow ? Color.YELLOW : Color.DKGRAY);
                    if (circle!=null) circle.draw(canvas);
                    isYellow = !isYellow;
                    holder.unlockCanvasAndPost(canvas);
                    if (circle!=null) circle.update(50);
                } catch (Exception e) {}

            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        circle = new MyCircle(event.getX(), event.getY());
        return super.onTouchEvent(event);
    }

    private MyCircle circle;

    class MyCircle {
        float x, y, radius;
        Paint paint;

        public MyCircle(float x, float y) {
            this.x = x;
            this.y = y;
            this.radius = 50;
            paint = new Paint();
            paint.setColor(Color.YELLOW);
        }

        void draw(Canvas canvas) {
            canvas.drawCircle(x, y, radius, paint);
        }

        void update(float fr) {
            radius += fr;
        }

    }

}
