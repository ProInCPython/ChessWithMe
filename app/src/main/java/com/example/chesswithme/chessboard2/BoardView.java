package com.example.chesswithme.chessboard2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.chesswithme.R;
import com.example.chesswithme.chessboard2.pieces.Bishop;
import com.example.chesswithme.chessboard2.pieces.King;
import com.example.chesswithme.chessboard2.pieces.Knight;
import com.example.chesswithme.chessboard2.pieces.LeftPawn;
import com.example.chesswithme.chessboard2.pieces.Pawn;
import com.example.chesswithme.chessboard2.pieces.Piece;
import com.example.chesswithme.chessboard2.pieces.Queen;
import com.example.chesswithme.chessboard2.pieces.Rook;

public class BoardView extends View {

    private Coordinate selection;
    private final Paint boardPaint = new Paint();
    private final Paint textPaint = new Paint();
    Piece p;

    public BoardView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        Board.newGame();
        Typeface bold = Typeface.DEFAULT_BOLD;
        textPaint.setTypeface(bold);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            int max = 8;
            int x = (int) (event.getX() / getWidth() * max);
            int y = max - 1 - (int) (event.getY() / getWidth() * max);
            Coordinate c = new Coordinate(x, y);
            if (c.isValid() && Board.getPiece(c) != null) {
                selection = c;
                invalidate();
            } else {
                if (selection != null) { // we have a piece selected and clicked on a new position
                    if (Board.move(selection, c)) {
                        selection = null;
                        invalidate();
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        int max = 8;
        float cellWidth = getWidth() / (float) max;
        Coordinate c;
        textPaint.setTextSize(cellWidth);
        boardPaint.reset();
        for (int x = 0; x < max; x++) {
            for (int y = 0; y < max; y++) {
                c = new Coordinate(x, y);
                if (c.isValid()) {
                    if ((x + y) % 2 == 0) boardPaint.setColor(Color.WHITE);
                    else boardPaint.setColor(Color.BLACK);
                    drawCoordinate(c, canvas, cellWidth, boardPaint, max);
                    if (isInEditMode()) continue;
                    try {
                        p = Board.getPiece(c);
                        if (p.getClass().equals(Bishop.class)) {
                            if (p.getPlayerColor().equals("white")) {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                        R.drawable.bishop_white), (int)cellWidth, (int)cellWidth, true), c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            } else {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.bishop_black), (int)cellWidth, (int)cellWidth, true), c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            }

                        } else if (p.getClass().equals(King.class)) {
                            if (p.getPlayerColor().equals("white")) {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                        R.drawable.king_white), (int)cellWidth, (int)cellWidth, true), c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            } else {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                        R.drawable.king_black), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            }

                        } else if (p.getClass().equals(Knight.class)) {
                            if (p.getPlayerColor().equals("white")) {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.knight_white), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            } else {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.knight_black), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            }

                        } else if (p.getClass().equals(Pawn.class)) {
                            if (p.getPlayerColor().equals("white")) {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.pawn_white), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            } else {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.pawn_black), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            }

                        } else if (p.getClass().equals(Queen.class)) {
                            if (p.getPlayerColor().equals("white")) {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.queen_white), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            } else {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.queen_black), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            }

                        } else if (p.getClass().equals(Rook.class)) {
                            if (p.getPlayerColor().equals("white")) {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.rook_white), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            } else {
                                canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(),
                                                R.drawable.rook_black), (int)cellWidth, (int)cellWidth, true),
                                        c.x * cellWidth, (max - c.y - 1) * cellWidth, null);
                            }

                        }
                    } catch (NullPointerException e) {

                    }


                }
            }
        }
        if (selection != null && (p = Board.getPiece(selection)) != null) {
            boardPaint.setAlpha(128);
            boardPaint.setStrokeWidth(4);
            boardPaint.setStyle(Paint.Style.STROKE);
            boardPaint.setColor(Color.CYAN);
            canvas.drawCircle(selection.x * cellWidth + cellWidth / 2,
                    (max - selection.y - 1) * cellWidth + cellWidth / 2, cellWidth / 2, boardPaint);
            for (Coordinate possible : p.getPossiblePositions()) {
                drawCoordinate(possible, canvas, cellWidth, boardPaint, max);
            }
        }
    }

    private void drawCoordinate(final Coordinate c, final Canvas canvas, final float cellWidth, final Paint paint, int max) {
        canvas.drawRect(c.x * cellWidth, (max - c.y - 1) * cellWidth, (c.x + 1) * cellWidth,
                (max - c.y) * cellWidth, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(Math.min(getMeasuredWidth(), getMeasuredHeight()),
                Math.min(getMeasuredWidth(), getMeasuredHeight()));
    }

}
