package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question1);
        TextView welcome= findViewById(R.id.welcomeText);
        TextView q1score= findViewById(R.id.q1scoreText);

        Button q1BackButton = findViewById(R.id.q1BackButton);
        Button q1NextButton = findViewById(R.id.q1NextButton);
        Button q1Check = findViewById(R.id.checkQ1);
        TextView warning = findViewById(R.id.q1WarningLabel);

        welcome.setText("Welcome, "+GlobalData.getInstance().getUser());
        q1score.setText(GlobalData.getInstance().getMark()+"/5");
        if(GlobalData.getInstance().getQuestionStatus(0)!=-1){
            warning.setText("You have already answered this Question! The Correct Answer is : An Operating System");
            q1NextButton.setEnabled(true);
            q1Check.setEnabled(false);
        }


        q1NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question1.this, Question2.class);
            startActivity(intent1);
        });

        q1BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question1.this, MainActivity.class);
            startActivity(intent1);
        });

        q1Check.setOnClickListener(v->{
            RadioGroup radioGroup = findViewById(R.id.q1radioGroup);

            int selectedId = radioGroup.getCheckedRadioButtonId(); // Get the ID of the selected RadioButton

            if (selectedId != -1) { // Check if any button is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();
                if(selectedText.equals("An Operating System")){
                    Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                    q1score.setText("1/5");
                    GlobalData.getInstance().setMark(1);
                    q1NextButton.setEnabled(true);
                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
                        View child = radioGroup.getChildAt(i);
                        if (child instanceof RadioButton) {
                            child.setEnabled(false); // Disable the RadioButton
                        }
                    }
                    GlobalData.getInstance().setQuestionStatus(0,1);
                }else{
                    GlobalData.getInstance().setQuestionStatus(0,0);
                    Toast.makeText(this, "Correct Answer is : An Operating System", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No selection made", Toast.LENGTH_SHORT).show();
            }
        });


    }
}