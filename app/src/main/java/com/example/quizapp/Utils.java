package com.example.quizapp;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Utils {

    public Utils() {
    }


    public static void AnswerQuestion(Context c, TextView score, Button next, RadioGroup radioGroup,Button check,Boolean correct,int questionNumber,String answer){
        if(correct){
            Toast.makeText(c, "Correct Answer!", Toast.LENGTH_SHORT).show();
            int mark = GlobalData.getInstance().getMark();
            mark++;
            GlobalData.getInstance().setMark(mark);
            score.setText(mark+"/5");
            GlobalData.getInstance().setQuestionStatus(questionNumber,1);
        }else{
            GlobalData.getInstance().setQuestionStatus(questionNumber,0);
            Toast.makeText(c, "Correct Answer is : "+answer, Toast.LENGTH_SHORT).show();
        }

        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            View child = radioGroup.getChildAt(i);
            if (child instanceof RadioButton) {
                child.setEnabled(false); // Disable the RadioButton
            }
        }
        check.setEnabled(false);
        next.setEnabled(true);
    }

    public static void InitPage(TextView welcome, TextView score, int questionNo, TextView warning,String answer, Button next, Button check){
        welcome.setText("Welcome, "+GlobalData.getInstance().getUser());
        score.setText(GlobalData.getInstance().getMark()+"/5");
        if(GlobalData.getInstance().getQuestionStatus(questionNo)!=-1){
            warning.setText("You have already answered this Question! The Correct Answer is : "+answer);
            next.setEnabled(true);
            check.setEnabled(false);
        }
    }
}
