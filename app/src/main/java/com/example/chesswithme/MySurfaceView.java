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
        circle = new MyCircle(100, 100);
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

        @Override
        public void run() {
            while(running) {
                Canvas canvas;
                try {
                    Thread.sleep(5);
                    canvas = holder.lockCanvas();
                    canvas.drawColor(Color.BLUE);
                    if (circle!=null) circle.draw(canvas);
                    holder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {}

            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        circle.update(event.getX(), event.getY());
        return super.onTouchEvent(event);
    }

    private MyCircle circle;

    class MyCircle {
        float x, y, radius, length, aimX, aimY, vX, vY;
        Paint paint;

        public MyCircle(float x, float y) {
            this.x = x;
            this.y = y;
            this.radius = 50;
            paint = new Paint();
            paint.setColor(Color.RED);
        }

        void draw(Canvas canvas) {
            if((float) Math.sqrt(Math.pow(aimX - x, 2) + Math.pow(aimY - y, 2)) > 1) {
                x += vX;
                y += vY;
                canvas.drawCircle(x, y, radius, paint);
            } else {
                x = aimX;
                y = aimY;
                canvas.drawCircle(x, y, radius, paint);
            }
        }

        void update(float aimX, float aimY) {
            this.aimX = aimX;
            this.aimY = aimY;
            vX = aimX - x;
            vY = aimY - y;
            length = (float) Math.sqrt(Math.pow(vX, 2) + Math.pow(vY, 2));
            vX /= length;
            vY /= length;




//            if (x != aimX && y != aimY) {
//                xSpeed = (Math.abs(x - aimX) > Math.abs(y - aimY)) ?
//                        (x - aimX) / Math.abs(y - aimY) :
//                        Math.abs(y - aimY) / (x - aimX);
//                ySpeed = (Math.abs(x - aimX) > Math.abs(y - aimY)) ?
//                        Math.abs(x - aimX) / (y - aimY) :
//                        (y - aimY) / Math.abs(x - aimX);
//            } else {
//                if (x == aimX) {
//                    ySpeed = aimY > y ? 20 : -20;
//                    xSpeed = 0;
//                }
//                if (y == aimY) {
//                    ySpeed = 0;
//                    xSpeed = aimX > x ? 20 : -20;
//                }
//                if (x == aimX && y == aimY) {
//                    xSpeed = 0;
//                    ySpeed = 0;
//                }
//            }
//            if (y - aimY != 0) {
//                xSpeed = (x - aimX) / (y - aimY);
//                if (x - aimX != 0) {
//                    ySpeed = 1 / xSpeed;
//                } else {
//                    if (y - aimY > 0) {
//                        ySpeed = 20;
//                    } else {
//                        ySpeed = -20;
//                    }
//                }
//            } else {
//                ySpeed = 0;
//                if (x - aimX == 0) {
//                    xSpeed = 0;
//                } else {
//                    if (x - aimX > 0) {
//                        xSpeed = 20;
//                    } else {
//                        xSpeed = -20;
//                    }
//                }
//            }
        }

    }

}
