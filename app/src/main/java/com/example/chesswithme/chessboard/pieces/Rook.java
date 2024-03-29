package com.example.chesswithme.chessboard.pieces;

import com.example.chesswithme.chessboard.Board;
import com.example.chesswithme.chessboard.Coordinate;

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


    public static List<Coordinate> moveStraight(final Piece p) {
        List<Coordinate> re = new LinkedList<>();

        // move to top
        int x = p.position.x;
        int y = p.position.y + 1;
        Coordinate c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            y++;
            c = new Coordinate(x, y);
            if (c.isValid() && !p.sameTeam(c)) {
                re.add(c);
            } else {
                break;
            }
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
            if (c.isValid() && !p.sameTeam(c)) {
                re.add(c);
            } else {
                break;
            }
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
            if (c.isValid() && !p.sameTeam(c)) {
                re.add(c);
            } else {
                break;
            }
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
            if (c.isValid() && !p.sameTeam(c)) {
                re.add(c);
            } else {
                break;
            }
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
