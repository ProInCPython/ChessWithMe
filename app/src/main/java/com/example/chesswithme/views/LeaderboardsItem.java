package com.example.chesswithme.views;

import java.util.Comparator;

public class LeaderboardsItem {

    private String position;
    private String username;
    private int points;

    private int profile_picture_resource;

    public LeaderboardsItem(String position, String username, int points, int profile_picture_resource) {
        this.position = position;
        this.username = username;
        this.points = points;
        this.profile_picture_resource = profile_picture_resource;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getProfile_picture_resource() {
        return profile_picture_resource;
    }

    public void setProfile_picture_resource(int profile_picture_resource) {
        this.profile_picture_resource = profile_picture_resource;
    }

    public static class UsersComparator implements Comparator<LeaderboardsItem> {

        @Override
        public int compare(LeaderboardsItem o1, LeaderboardsItem o2) {
            return Integer.compare(o2.getPoints(), o1.getPoints());
        }
    }

}
