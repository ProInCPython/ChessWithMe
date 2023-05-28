package com.example.chesswithme.chessboard.pieces;

import com.example.chesswithme.chessboard.Board;
import com.example.chesswithme.chessboard.Coordinate;

import java.util.List;

public abstract class Piece {

    public Coordinate position;

    private final String ownerColor;

    Piece(final Coordinate p, final String o) {
        position = p;
        ownerColor = o;
    }


    public abstract List<Coordinate> getPossiblePositions();


    public String getPlayerColor() {
        return ownerColor;
    }


    public boolean sameTeam(final Coordinate destination) {
        Piece p = Board.getPiece(destination);
        return p != null && p.ownerColor.equals(ownerColor);
    }


    public abstract String getString();

    @Override
    public String toString() {
        Coordinate c = new Coordinate(position.x, position.y);
        return c.toString() + "," + ownerColor + "," + getClass().getSimpleName();
    }
}
