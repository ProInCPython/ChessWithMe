package com.example.chesswithme.chessboard.pieces;

import com.example.chesswithme.chessboard.Board;
import com.example.chesswithme.chessboard.Coordinate;

import java.util.LinkedList;
import java.util.List;

public class LeftPawn extends Piece {
    public LeftPawn(final Coordinate p, final String o) {
        super(p, o);
    }

    @Override
    public List<Coordinate> getPossiblePositions() {
        List<Coordinate> re = new LinkedList<Coordinate>();
        Coordinate c;
        int x = position.x;
        int y = position.y;
        c = new Coordinate(x - 1, y);
        if (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
        }
        // can move two squares at the beginning
        // (only if no other piece stands 1 before us)
        if (x == 10 && Board.getPiece(c) == null) {
            c = new Coordinate(x - 2, y);
            if (c.isValid() && Board.getPiece(c) == null) {
                re.add(c);
            }
        }

        // check if we can attack another piece
        c = new Coordinate(x - 1, y - 1);
        if (c.isValid() && Board.getPiece(c) != null && !sameTeam(c)) {
            re.add(c);
        }
        c = new Coordinate(x - 1, y + 1);
        if (c.isValid() && Board.getPiece(c) != null && !sameTeam(c)) {
            re.add(c);
        }
        return re;
    }

    @Override
    public String getString() {
        return "\u265F";
    }
}
