package com.example.chesswithme.firebase;

public class ChessUserInfo {
    private String username;
    private double dailyPoints;
    private double weeklyPoints;
    private double monthlyPoints;
    private double completedLessons;
    private double profilePicture;

    public ChessUserInfo() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getDailyPoints() {
        return dailyPoints;
    }

    public void setDailyPoints(double dailyPoints) {
        this.dailyPoints = dailyPoints;
    }

    public double getWeeklyPoints() {
        return weeklyPoints;
    }

    public void setWeeklyPoints(double weeklyPoints) {
        this.weeklyPoints = weeklyPoints;
    }

    public double getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(double monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public double getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(double completedLessons) {
        this.completedLessons = completedLessons;
    }

    public double getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(double profilePicture) {
        this.profilePicture = profilePicture;
    }
}
