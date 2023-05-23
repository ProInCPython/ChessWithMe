package com.example.chesswithme.views;

import com.example.chesswithme.R;

public class LessonItem {
    private String text;
    private String module;
    private String lesson_name;
    private String simple_lesson_name;
    public int picture_resource;
    private boolean isClicked;
    private int previousClickedPosition;
    private int completed_lessons;
    private boolean isTitle;

    public LessonItem(String text, String module, String lesson_name, String simple_lesson_name, int picture_resource, boolean isClicked, int previousClickedPosition, int completed_lessons, boolean isTitle) {
        this.text = text;
        this.module = module;
        this.lesson_name = lesson_name;
        this.simple_lesson_name = simple_lesson_name;
        this.picture_resource = picture_resource;
        this.isClicked = isClicked;
        this.previousClickedPosition = previousClickedPosition;
        this.completed_lessons = completed_lessons;
        this.isTitle = isTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public String getSimple_lesson_name() {
        return simple_lesson_name;
    }

    public void setSimple_lesson_name(String simple_lesson_name) {
        this.simple_lesson_name = simple_lesson_name;
    }

    public int getPicture_resource() {
        return picture_resource;
    }

    public void setPicture_resource(int picture_resource) {
        this.picture_resource = picture_resource;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public int getPreviousClickedPosition() {
        return previousClickedPosition;
    }

    public void setPreviousClickedPosition(int previousClickedPosition) {
        this.previousClickedPosition = previousClickedPosition;
    }

    public int getCompleted_lessons() {
        return completed_lessons;
    }

    public void setCompleted_lessons(int completed_lessons) {
        this.completed_lessons = completed_lessons;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }
}
