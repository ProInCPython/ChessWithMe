package com.example.chesswithme.chessboard;

public class Coordinate {

    public final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }

    public boolean isValid() {
        return (x >= 0 && y >= 0 && x <= 7 && y <= 7);
    }

    @Override
    public boolean equals(final Object other) {
        return other instanceof Coordinate && ((Coordinate) other).x == x &&
                ((Coordinate) other).y == y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
