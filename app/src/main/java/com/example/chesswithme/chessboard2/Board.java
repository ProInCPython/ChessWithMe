package com.example.chesswithme.chessboard2;

import android.util.Pair;

import com.example.chesswithme.chessboard2.pieces.Bishop;
import com.example.chesswithme.chessboard2.pieces.King;
import com.example.chesswithme.chessboard2.pieces.Knight;
import com.example.chesswithme.chessboard2.pieces.LeftPawn;
import com.example.chesswithme.chessboard2.pieces.Pawn;
import com.example.chesswithme.chessboard2.pieces.Piece;
import com.example.chesswithme.chessboard2.pieces.Queen;
import com.example.chesswithme.chessboard2.pieces.Rook;

public class Board {

    private Board() {
    }

    private static Piece[][] BOARD = new Piece[8][8];

//    /**
//     * Remove all pieces belonging to the given player
//     *
//     * @param playerId the player id who's pieces should be removed
//     */
//    public static void removePlayer(final String playerId) {
//        for (int x = 0; x < (extendedBoard ? 12 : 8); x++) {
//            for (int y = 0; y < (extendedBoard ? 12 : 8); y++) {
//                if (BOARD[x][y] != null && playerId.equals(BOARD[x][y].getPlayerId())) {
//                    BOARD[x][y] = null;
//                }
//            }
//        }
//    }

    /**
     * Move a piece
     *
     * @param old_pos old position of the piece
     * @param new_pos new position
     * @return false, if that move is not legal
     */
    public static boolean move(final Coordinate old_pos, final Coordinate new_pos) {

        if (!new_pos.isValid()) return false; // not a valid new position

        Piece p = BOARD[old_pos.x][old_pos.y];
        if (!p.getPossiblePositions().contains(new_pos)) return false; // not possible to move there

        Piece target = BOARD[new_pos.x][new_pos.y];

        // move the piece
        BOARD[new_pos.x][new_pos.y] = BOARD[old_pos.x][old_pos.y];
        BOARD[old_pos.x][old_pos.y] = null;
        p.position = new_pos;
        return true;
    }

    /**
     * Gets a piece from the board
     *
     * @param c the coordinate of the piece to get
     * @return the piece or null, if there is none at the given coordinate
     */
    public static Piece getPiece(final Coordinate c) {
        return BOARD[c.x][c.y];
    }

    /**
     * Get a string representation of this board
     *
     * @return the board, represented as a string
     */
    public static String getString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (BOARD[x][y] != null) {
                    sb.append(BOARD[x][y].toString());
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }

    /**
     * Sets the player at the top or the bottom up
     *
     * @param x_begin  x-coordinate of the left-most piece
     * @param y_pawns  y-coordinate of the rows of pawns
     * @param y_others y-coordinate of the rows of other pieces
     * @param owner    player.id who owns these pieces
     */
    private static void setupPlayerTopBottom(int x_begin, int y_pawns, int y_others, final String owner) {
        for (int x = x_begin; x < x_begin + 8; x++) {
            BOARD[x][y_pawns] = new Pawn(new Coordinate(x, y_pawns), owner);
        }
        BOARD[x_begin][y_others] = new Rook(new Coordinate(x_begin, y_others), owner);
        BOARD[x_begin + 1][y_others] = new Knight(new Coordinate(x_begin + 1, y_others), owner);
        BOARD[x_begin + 2][y_others] = new Bishop(new Coordinate(x_begin + 2, y_others), owner);
        BOARD[x_begin + 3][y_others] = new King(new Coordinate(x_begin + 4, y_others), owner);
        BOARD[x_begin + 4][y_others] = new Queen(new Coordinate(x_begin + 3, y_others), owner);
        BOARD[x_begin + 5][y_others] = new Bishop(new Coordinate(x_begin + 5, y_others), owner);
        BOARD[x_begin + 6][y_others] = new Knight(new Coordinate(x_begin + 6, y_others), owner);
        BOARD[x_begin + 7][y_others] = new Rook(new Coordinate(x_begin + 7, y_others), owner);
    }

    /**
     * Initialize a new game
     */
    public static void newGame() {
        // setup player 1 (bottom)
        setupPlayerTopBottom(0, 1, 0, "white");
        // setup player 2 (top)
        setupPlayerTopBottom(0, 6, 7, "black");
    }

}
