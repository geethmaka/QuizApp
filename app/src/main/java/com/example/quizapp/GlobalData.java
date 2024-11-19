package com.example.quizapp;

public class GlobalData {
    private static GlobalData instance;
    private String globalString;
    private int mark;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }



    private GlobalData() {
        // Private constructor to prevent instantiation
    }

    public static GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }
}
