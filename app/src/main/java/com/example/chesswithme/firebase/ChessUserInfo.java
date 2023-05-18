package com.example.chesswithme.firebase;

public class ChessUserInfo {
    private String username;
    private String email;
    private int dailyPoints;
    private int weeklyPoints;
    private int monthlyPoints;
    private int completedLessons;
    private int profilePicture;

    public ChessUserInfo() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDailyPoints() {
        return dailyPoints;
    }

    public void setDailyPoints(int dailyPoints) {
        this.dailyPoints = dailyPoints;
    }

    public int getWeeklyPoints() {
        return weeklyPoints;
    }

    public void setWeeklyPoints(int weeklyPoints) {
        this.weeklyPoints = weeklyPoints;
    }

    public int getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(int monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(int completedLessons) {
        this.completedLessons = completedLessons;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}
