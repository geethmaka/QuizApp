package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);
        TextView welcome= findViewById(R.id.welcomeText);
        TextView q2score= findViewById(R.id.q2scoreText);

        Button q2BackButton = findViewById(R.id.q2BackButton);
        Button q2NextButton = findViewById(R.id.q2NextButton);
        Button q2Check = findViewById(R.id.checkq2);
        TextView warning = findViewById(R.id.q2WarningLabel);
        RadioGroup q2radioGroup = findViewById(R.id.q2radioGroup);

        int questionNumber = 1;
        String CorrectAnswer = "Mobile devices";

        Utils.InitPage(welcome,q2score,questionNumber,warning,CorrectAnswer,q2NextButton,q2Check);


        q2NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question2.this, Question3.class);
            startActivity(intent1);
        });

        q2BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question2.this, Question1.class);
            startActivity(intent1);
        });

        q2Check.setOnClickListener(v->{
            int selectedId = q2radioGroup.getCheckedRadioButtonId(); // Get the ID of the selected RadioButton

            if (selectedId != -1) { // Check if any button is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();

                // Instead of if it's just checking the answer value
                Utils.AnswerQuestion(this,q2score,q2NextButton,q2radioGroup,q2Check, selectedText.equals(CorrectAnswer),questionNumber,CorrectAnswer);

            } else {
                Toast.makeText(this, "No selection made", Toast.LENGTH_SHORT).show();
            }
        });
    }
}