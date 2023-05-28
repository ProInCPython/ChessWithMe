package com.example.chesswithme.chessboard.pieces;

import com.example.chesswithme.chessboard.Board;
import com.example.chesswithme.chessboard.Coordinate;

import java.util.LinkedList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(final Coordinate p, final String o) {
        super(p, o);
    }

    @Override
    public List<Coordinate> getPossiblePositions() {
        return moveDiagonal(this);
    }

    public static List<Coordinate> moveDiagonal(final Piece p) {
        List<Coordinate> re = new LinkedList<Coordinate>();
        int x = p.position.x + 1;
        int y = p.position.y + 1;
        Coordinate c = new Coordinate(x, y);

        // move to top right
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            y++;
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


        // move to bottom right
        x = p.position.x + 1;
        y = p.position.y - 1;
        c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            y--;
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


        // move top left
        x = p.position.x - 1;
        y = p.position.y + 1;
        c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            x--;
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


        // move bottom left
        x = p.position.x - 1;
        y = p.position.y - 1;
        c = new Coordinate(x, y);
        while (c.isValid() && Board.getPiece(c) == null) {
            re.add(c);
            x--;
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


        return re;
    }

    @Override
    public String getString() {
        return "\u265D";
    }
}
