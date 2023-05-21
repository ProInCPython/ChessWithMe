package com.example.chesswithme.views;

import com.example.chesswithme.R;

public class LessonItem {
    private String text;
    private String module;
    private String lesson_name;
    private String simple_lesson_name;
    public int picture_resource;

    public LessonItem(String text, String module, String lesson_name, String simple_lesson_name, int picture_resource) {
        this.text = text;
        this.module = module;
        this.lesson_name = lesson_name;
        this.simple_lesson_name = simple_lesson_name;
        this.picture_resource = picture_resource;
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
}
