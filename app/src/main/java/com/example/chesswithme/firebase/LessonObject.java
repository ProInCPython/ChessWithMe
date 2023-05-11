package com.example.chesswithme.firebase;


public class LessonObject {
    private String finish_conditions;
    private String initial_position;
    private String userColor;

    public LessonObject() {
    }

    public String getFinish_conditions() {
        return finish_conditions;
    }

    public void setFinish_conditions(String finish_conditions) {
        this.finish_conditions = finish_conditions;
    }

    public String getInitial_position() {
        return initial_position;
    }

    public void setInitial_position(String initial_position) {
        this.initial_position = initial_position;
    }

    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }
}
