package com.example.chesswithme.chessboard;

public class Game {

//    private final static int PROTOCOL_VERSION = 1;
//
////    private final static int[] PLAYER_COLOR =
////            {Color.parseColor("#FF8800"), Color.parseColor("#99CC00"), Color.parseColor("#33B5E5"),
////                    Color.parseColor("#CC0000")};
////
////    public final static int MODE_2_PLAYER_2_SIDES = 1;
////    public final static int MODE_2_PLAYER_4_SIDES = 2;
////    public final static int MODE_4_PLAYER_TEAMS = 3;
////    public final static int MODE_4_PLAYER_NO_TEAMS = 4;
////
////    public static int match_mode;
////
////    public static String myPlayerId;
//    public static Player[] players;
////    public static int turns;
////
////    private static List<String> deadPlayers;
//
//    public static LessonActivity UI;
//
//    /**
//     * Should be called when a move is made
//     */
//    public static void moved() {
//        if (UI != null) UI.updateTurn();
//    }
//
//
//    /**
//     * Load game data
//     *
//     * @param data the data to load
//     * @param m    the match
//     * @param a    the ApiClient
//     * @return false, if protocol version is too old and the app should be updated first
//     */
//    public static boolean load(final byte[] data) {
////        String[] s = new String(data).split(":");
////        // newer protocol used for the match
////        if (s.length > 6 && s[6] != null && Integer.parseInt(s[6]) > PROTOCOL_VERSION) {
////            return false;
////        }
////        if (s.length > 3 && s[3] != null) {
////            for (String dead : s[3].split(",")) {
////                if (dead != null && dead.length() > 0) deadPlayers.add(dead);
////            }
////        }
////        if (s.length > 5 && s[5] != null) {
////            match_mode = Integer.parseInt(s[5]);
////        }
////        if (!s[1].contains(players[1].id)) {
////            s[2] = s[2].replace("AutoMatch_2", players[1].id);
////        }
////        if (players.length > 2) {
////            if (!s[1].contains(players[2].id)) {
////                s[2] = s[2].replace("AutoMatch_3", players[2].id);
////            }
////            if (!s[1].contains(players[3].id)) {
////                s[2] = s[2].replace("AutoMatch_4", players[3].id);
////            }
////        }
////        Board.load(s[2], match_mode);
////        if (s.length > 4 && s[4] != null) {
////            String[] lastMoves = s[4].split(";");
////            String[] coords;
////            for (int i = 0; i < lastMoves.length; i++) {
////                if (lastMoves[i].equals("-")) continue;
////                coords = lastMoves[i].split(",");
////                players[i].lastMove = new Pair<Coordinate, Coordinate>(
////                        new Coordinate(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]),
////                                Board.getRotation()),
////                        new Coordinate(Integer.parseInt(coords[2]), Integer.parseInt(coords[3]),
////                                Board.getRotation()));
////            }
////        }
//        return true;
//    }
//
////    private static void createPlayers() {
////        int num_players = match.getParticipants().size() + match.getAvailableAutoMatchSlots();
////        players = new Player[num_players];
////        players[0] =
////                new Player(match.getParticipants().get(0).getParticipantId(), 1, PLAYER_COLOR[0],
////                        match.getParticipants().get(0).getDisplayName());
////        if (match.getParticipants().size() > 1) {
////            players[1] = new Player(match.getParticipants().get(1).getParticipantId(),
////                    match_mode == MODE_4_PLAYER_TEAMS ? 1 : 2, PLAYER_COLOR[1],
////                    match.getParticipants().get(1).getDisplayName());
////        } else {
////            players[1] = new Player("AutoMatch_2", match_mode == MODE_4_PLAYER_TEAMS ? 1 : 2,
////                    PLAYER_COLOR[1], "Waiting for player...");
////        }
////        if (num_players > 2) {
////            if (match.getParticipants().size() > 2) {
////                players[2] = new Player(match.getParticipants().get(2).getParticipantId(),
////                        match_mode == MODE_4_PLAYER_TEAMS ? 2 : 3, PLAYER_COLOR[2],
////                        match.getParticipants().get(2).getDisplayName());
////            } else {
////                players[2] = new Player("AutoMatch_3", match_mode == MODE_4_PLAYER_TEAMS ? 2 : 3,
////                        PLAYER_COLOR[2], "Waiting for player...");
////            }
////            if (match.getParticipants().size() > 3) {
////                players[3] = new Player(match.getParticipants().get(3).getParticipantId(),
////                        match_mode == MODE_4_PLAYER_TEAMS ? 2 : 4, PLAYER_COLOR[3],
////                        match.getParticipants().get(3).getDisplayName());
////            } else {
////                players[3] = new Player("AutoMatch_4", match_mode == MODE_4_PLAYER_TEAMS ? 2 : 4,
////                        PLAYER_COLOR[3], "Waiting for player...");
////            }
////        }
////        myPlayerId = match.getParticipantId(Games.Players.getCurrentPlayerId(api));
////        if (BuildConfig.DEBUG) Logger.log("Game.createPlayers, " + players[0].id + ", " +
////                players[1].id +
////                ((players.length > 2) ? ", " + players[2].id + ", " + players[3].id : ""));
////    }
//
//    /**
//     * Checks if id1 and id2 are on the same team
//     *
//     * @param id1 player1
//     * @param id2 player2
//     * @return true, if player1 and player2 are on the same team
//     */
//    public static boolean sameTeam(final String id1, final String id2) {
//        return getPlayer(id1).team == getPlayer(id2).team;
//    }
//
//    /**
//     * Gets the color of the player with the id 'id'
//     *
//     * @param id the player id
//     * @return the player's color
//     */
//    public static int getPlayerColor(final String id) {
//        return getPlayer(id).color;
//    }
//
//    /**
//     * Gets the player object to the given id
//     *
//     * @param id the player id
//     * @return the player or null, if no such player exists
//     */
//    public static Player getPlayer(final String id) {
//        for (Player p : players) {
//            if (p.id.equals(id)) return p;
//        }
//        return null;
//    }
}
