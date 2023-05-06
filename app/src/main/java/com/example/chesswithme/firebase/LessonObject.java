package com.example.chesswithme.firebase;


import java.util.ArrayList;

public class LessonObject {
    private String initial_position;
    private ArrayList<String> description;
    private String finish_conditions;
    private String userColor;

    public LessonObject(String initial_position, ArrayList<String> description, String finish_conditions, String userColor) {
        this.initial_position = initial_position;
        this.description = description;
        this.finish_conditions = finish_conditions;
        this.userColor = userColor;
    }

    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }

    public String getInitial_position() {
        return initial_position;
    }

    public void setInitial_position(String initial_position) {
        this.initial_position = initial_position;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public String getFinish_conditions() {
        return finish_conditions;
    }

    public void setFinish_conditions(String finish_conditions) {
        this.finish_conditions = finish_conditions;
    }
}
