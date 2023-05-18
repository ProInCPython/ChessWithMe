package com.example.chesswithme.views;

public class LessonItem {
    private String text;
    private String module;
    private String lesson_name;
    private String simple_lesson_name;

    public LessonItem(String text, String module, String lesson_name, String simple_lesson_name) {
        this.text = text;
        this.module = module;
        this.lesson_name = lesson_name;
        this.simple_lesson_name = simple_lesson_name;
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
}
