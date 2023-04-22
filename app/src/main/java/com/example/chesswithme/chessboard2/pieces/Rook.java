package com.example.chesswithme.chessboard2.pieces;

import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.chessboard2.Coordinate;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {

    public Rook(final Coordinate p, final String o) {
        super(p, o);
    }

    @Override
    public List<Coordinate> getPossiblePositions() {
        return moveStraight(this);
    }

    /**
     * Get a list of possible positions, if the piece can only move straight from its current position
     *
     * @param p the piece
     * @return a list of possible positions
     */
    public static List<Coordinate> moveStraight(final Piece p) {
        List<Coordinate> re = new LinkedList<Coordinate>();

        // move to top
        int x = p.position.x;
        int y = p.position.y + 1;
        Coordinate c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            y++;
            c = new Coordinate(x, y);
        }
        if (c.isValid() && !p.sameTeam(c)) {
            re.add(c);
        }

        // move to bottom
        y = p.position.y - 1;
        c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            y--;
            c = new Coordinate(x, y);
        }
        if (c.isValid() && !p.sameTeam(c)) {
            re.add(c);
        }

        // move right
        y = p.position.y;
        x = p.position.x + 1;
        c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            x++;
            c = new Coordinate(x, y);
        }
        if (c.isValid() && !p.sameTeam(c)) {
            re.add(c);
        }

        // move left
        x = p.position.x - 1;
        c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            x--;
            c = new Coordinate(x, y);
        }
        if (c.isValid() && !p.sameTeam(c)) {
            re.add(c);
        }

        return re;
    }

    @Override
    public String getString() {
        return "\u265C";
    }
}
