package com.example.quizapp;

public class GlobalData {
    private static GlobalData instance;
    private int mark=0;

    public int getQuestionStatus(int i) {
        return questionStatus[i];
    }

    public void setQuestionStatus(int i,int questionStatus) {
        this.questionStatus[i] = questionStatus;
    }

    private int[] questionStatus= new int[]{-1, -1, -1, -1, -1};

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private String user;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }



    private GlobalData() {}

    public static GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }

    public void clearAllData(){
        this.questionStatus= new int[]{-1, -1, -1, -1, -1};
        this.mark=0;
        this.user="";
    }
}
