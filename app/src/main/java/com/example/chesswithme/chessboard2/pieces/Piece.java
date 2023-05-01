package com.example.chesswithme.chessboard2.pieces;

import com.example.chesswithme.chessboard2.Board;
import com.example.chesswithme.chessboard2.Coordinate;
import com.example.chesswithme.chessboard2.Game;

import java.util.List;

public abstract class Piece {

    /**
     * The current position
     */
    public Coordinate position;

    /**
     * The player ID who owns this piece
     */
    private final String ownerColor;

    /**
     * Construct a new piece
     *
     * @param p the coordinate where this piece is located
     * @param o the ID of the player who owns this piece
     */
    Piece(final Coordinate p, final String o) {
        position = p;
        ownerColor = o;
    }

    /**
     * Gets possible new positions for the current piece
     *
     * @return a list of possible new coordinates
     */
    public abstract List<Coordinate> getPossiblePositions();

    /**
     * Gets the player ID, to whom this piece belongs
     *
     * @return the owner id of this piece
     */
    public String getPlayerColor() {
        return ownerColor;
    }

    /**
     * Checks if this piece belongs to the same team as the destination piece
     *
     * @param destination the piece to check against
     * @return true, if both pieces belong to the same team or same player
     */
    public boolean sameTeam(final Coordinate destination) {
        Piece p = Board.getPiece(destination);
        return p != null && p.ownerColor.equals(ownerColor);
    }

    /**
     * @return the unicode representation of this piece
     */
    public abstract String getString();

    @Override
    public String toString() {
        Coordinate c = new Coordinate(position.x, position.y);
        return c.toString() + "," + ownerColor + "," + getClass().getSimpleName();
    }
}
