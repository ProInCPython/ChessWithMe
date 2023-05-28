package com.example.chesswithme.chessboard;

import com.example.chesswithme.chessboard.pieces.Bishop;
import com.example.chesswithme.chessboard.pieces.King;
import com.example.chesswithme.chessboard.pieces.Knight;
import com.example.chesswithme.chessboard.pieces.Pawn;
import com.example.chesswithme.chessboard.pieces.Piece;
import com.example.chesswithme.chessboard.pieces.Queen;
import com.example.chesswithme.chessboard.pieces.Rook;
import com.example.chesswithme.firebase.FirebaseReceiver;

public class Board {

    public Board() {
    }

    private static Piece[][] BOARD;
    public static String userColor = "white";
    public boolean isNextChallenge;
    public static String mode;
    public boolean isPawnPromoted = false;
    public static FirebaseReceiver firebaseReceiver = new FirebaseReceiver();

    public boolean move(final Coordinate old_pos, final Coordinate new_pos) {

        if (!new_pos.isValid()) return false; // not a valid new position

        Piece p = BOARD[old_pos.x][old_pos.y];
        if (!p.getPossiblePositions().contains(new_pos)) return false; // not possible to move there

        Piece target = BOARD[new_pos.x][new_pos.y];

        // move the piece
        BOARD[new_pos.x][new_pos.y] = BOARD[old_pos.x][old_pos.y];
        BOARD[old_pos.x][old_pos.y] = null;
        p.position = new_pos;
        for (int x = 0; x < 8; x++) {
            if (BOARD[x][7] != null && BOARD[x][7].getClass().equals(Pawn.class) && BOARD[x][7].getPlayerColor().equals(userColor)) {
                isPawnPromoted = true;
                BOARD[x][7] = new Queen(new Coordinate(x, 7), userColor);
            }
        }
        isNextChallenge = isFinishCondition(firebaseReceiver.getFinish_conditions());
//        userColor = userColor.equals("white") ? "black" : "white";
//        BoardView.userColor = userColor;
//        flip();
        return true;
    }

    public void load(final String data, String user, String mode) {
        Board.mode = mode;
        userColor = user;
        if (userColor.equals("white")) {
            String[] pieceData;
            Coordinate c;
            BOARD = new Piece[8][8];
            for (String piece : data.split(";")) {
                pieceData = piece.split(",");
                c = new Coordinate(Integer.parseInt(pieceData[0]), Integer.parseInt(pieceData[1]));
                switch (pieceData[3]) {
                    case "Bishop":
                        BOARD[c.x][c.y] = new Bishop(c, pieceData[2]);
                        break;
                    case "King":
                        BOARD[c.x][c.y] = new King(c, pieceData[2]);
                        break;
                    case "Knight":
                        BOARD[c.x][c.y] = new Knight(c, pieceData[2]);
                        break;
                    case "Pawn":
                        BOARD[c.x][c.y] = new Pawn(c, pieceData[2]);
                        break;
                    case "Queen":
                        BOARD[c.x][c.y] = new Queen(c, pieceData[2]);
                        break;
                    case "Rook":
                        BOARD[c.x][c.y] = new Rook(c, pieceData[2]);
                        break;
                }
            }
        } else if(userColor.equals("black")){
            String[] pieceData;
            Coordinate c;
            BOARD = new Piece[8][8];
            for (String piece : data.split(";")) {
                pieceData = piece.split(",");
                c = new Coordinate(7 - Integer.parseInt(pieceData[0]), 7 - Integer.parseInt(pieceData[1]));
                if (pieceData[3].equals("Bishop")) {
                    BOARD[c.x][c.y] = new Bishop(c, pieceData[2]);
                } else if (pieceData[3].equals("King")) {
                    BOARD[c.x][c.y] = new King(c, pieceData[2]);
                } else if (pieceData[3].equals("Knight")) {
                    BOARD[c.x][c.y] = new Knight(c, pieceData[2]);
                } else if (pieceData[3].equals("Pawn")) {
                    BOARD[c.x][c.y] = new Pawn(c, pieceData[2]);
                } else if (pieceData[3].equals("Queen")) {
                    BOARD[c.x][c.y] = new Queen(c, pieceData[2]);
                } else if (pieceData[3].equals("Rook")) {
                    BOARD[c.x][c.y] = new Rook(c, pieceData[2]);
                }
            }
            flip();
        }

    }

    public static Piece getPiece(final Coordinate c) {
        return BOARD[c.x][c.y];
    }

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


    private static void setupPlayerTopBottom(int x_begin, int y_pawns, int y_others, final String owner) {
        for (int x = x_begin; x < x_begin + 8; x++) {
            BOARD[x][y_pawns] = new Pawn(new Coordinate(x, y_pawns), owner);
        }
        BOARD[x_begin][y_others] = new Rook(new Coordinate(x_begin, y_others), owner);
        BOARD[x_begin + 1][y_others] = new Knight(new Coordinate(x_begin + 1, y_others), owner);
        BOARD[x_begin + 2][y_others] = new Bishop(new Coordinate(x_begin + 2, y_others), owner);
        BOARD[x_begin + 3][y_others] = new King(new Coordinate(x_begin + 3, y_others), owner);
        BOARD[x_begin + 4][y_others] = new Queen(new Coordinate(x_begin + 4, y_others), owner);
        BOARD[x_begin + 5][y_others] = new Bishop(new Coordinate(x_begin + 5, y_others), owner);
        BOARD[x_begin + 6][y_others] = new Knight(new Coordinate(x_begin + 6, y_others), owner);
        BOARD[x_begin + 7][y_others] = new Rook(new Coordinate(x_begin + 7, y_others), owner);
    }

    /**
     * Initialize a new game
     */
    public static void newGame() {
        BOARD = new Piece[8][8];
        // setup player 1 (bottom)
        setupPlayerTopBottom(0, 1, 0, "white");
        // setup player 2 (top)
        setupPlayerTopBottom(0, 6, 7, "black");
    }

    public static boolean isFinishCondition(String finish_condition) {
        switch (finish_condition) {
            case "Queen on the board":
                for (int x = 0; x < 8; x++) {
                    if (BOARD[x][7] != null && BOARD[x][7].getClass().equals(Queen.class) && BOARD[x][7].getPlayerColor().equals(userColor)) {
                        return true;
                    }
                }
                return false;

            case "Pawn promotion":
                for (int x = 0; x < 8; x++) {
                    if (BOARD[x][7] != null && BOARD[x][7].getClass().equals(Pawn.class) && BOARD[x][7].getPlayerColor().equals(userColor)) {
                        return true;
                    }
                }
                return false;
            case "No opponent pieces":
                int counter = 0;
                for (int x = 0; x < 8; x++) {
                    for(int y = 0; y < 8;y++) {
                        if (BOARD[x][y] != null && !BOARD[x][y].getPlayerColor().equals(userColor)) {
                            counter += 1;
                        }
                    }
                }
                return counter == 0;
            default:
                return false;
        }
    }

    public static void flip() {
        String data = getString();
        String[] pieceData;
        Coordinate c;
        BOARD = new Piece[8][8];
        for (String piece : data.split(";")) {
            pieceData = piece.split(",");
            c = new Coordinate(7 - Integer.parseInt(pieceData[0]), 7 - Integer.parseInt(pieceData[1]));
            if (pieceData[3].equals("Bishop")) {
                BOARD[c.x][c.y] = new Bishop(c, pieceData[2]);
            } else if (pieceData[3].equals("King")) {
                BOARD[c.x][c.y] = new King(c, pieceData[2]);
            } else if (pieceData[3].equals("Knight")) {
                BOARD[c.x][c.y] = new Knight(c, pieceData[2]);
            } else if (pieceData[3].equals("Pawn")) {
                BOARD[c.x][c.y] = new Pawn(c, pieceData[2]);
            } else if (pieceData[3].equals("Queen")) {
                BOARD[c.x][c.y] = new Queen(c, pieceData[2]);
            } else if (pieceData[3].equals("Rook")) {
                BOARD[c.x][c.y] = new Rook(c, pieceData[2]);
            }
        }
    }
}
