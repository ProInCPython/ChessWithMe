package com.example.chesswithme.chessboard2.pieces;

import com.example.chesswithme.chessboard2.Coordinate;

import java.util.List;

public class Queen extends Piece {

    public Queen(final Coordinate p, final String o) {
        super(p, o);
    }

    @Override
    public List<Coordinate> getPossiblePositions() {
        List<Coordinate> re = Rook.moveStraight(this);
        re.addAll(Bishop.moveDiagonal(this));
        return re;
    }

    @Override
    public String getString() {
        return "\u265B";
    }
}
