package com.example.chesswithme.chessboard2;

public class Coordinate {

    public final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Checks if the coordinate is on the board
     *
     * @return true, if the coordinate is valid
     */
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