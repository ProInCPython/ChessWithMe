package com.example.chesswithme.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.chesswithme.R;

import java.nio.channels.Pipe;
import java.security.cert.Extension;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private final Bitmap background;
    private static final int FPS = 300;
    private SurfaceHolder surfaceHolder;
    private DrawThread drawThread;
    private Bird bird;
    private Tile pipe;




    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
        drawThread = new DrawThread();
        getHolder().addCallback(this);
    }
    
    private void init() {
        bird = new Bird(getContext(), 200, getHeight() / 2f);
        pipe = new Tile(getContext(), getHeight(), getWidth());
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        bird = new Bird(getContext(), 200, getHeight() / 2f);
        pipe = new Tile(getContext(), getHeight(), getWidth());
        drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    private void drawFrames (Canvas canvas) {
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(background, null, rect, null);
        canvas.drawBitmap(bird.getSprite(), bird.x, bird.y, null);
        canvas.drawBitmap(pipe.getToppipe(), pipe.x, 0, null);
        canvas.drawBitmap(pipe.getBottompipe(), bird.x, getHeight() - pipe.getBottompipe().getHeight(), null);


    }

    private void update() {
        bird.update();
        pipe.update();
        if (pipe.isCollision(bird) || bird.y <= 0 || bird.y >= getHeight()) {
            drawThread.running = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        bird.fly();
        if (!drawThread.running) {
            drawThread = new DrawThread();
            init();
            drawThread.start();
        }
        return super.onTouchEvent(event);
    }

    private class DrawThread extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            Canvas canvas;
            while(running) {
                canvas = surfaceHolder.lockCanvas();
                try {
                    sleep(1000 / FPS);
                    drawFrames(canvas);
                    update();
                } catch (Exception e) {
                    Log.e("RRR", "run", e);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

}
