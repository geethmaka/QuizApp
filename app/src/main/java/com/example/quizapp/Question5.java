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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question5 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question5);
        TextView welcome= findViewById(R.id.welcomeText);
        TextView q5score= findViewById(R.id.q5scoreText);

        Button q5BackButton = findViewById(R.id.q5BackButton);
        Button q5NextButton = findViewById(R.id.q5NextButton);
        Button q5Check = findViewById(R.id.checkq5);
        TextView warning = findViewById(R.id.q5WarningLabel);
        RadioGroup q5radioGroup = findViewById(R.id.q5radioGroup);

        int questionNumber = 4;
        String CorrectAnswer = "Android Package Kit";

        Utils.InitPage(welcome,q5score,questionNumber,warning,CorrectAnswer,q5NextButton,q5Check);


        q5NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question5.this, FinalPage.class);
            startActivity(intent1);
        });

        q5BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question5.this, Question4.class);
            startActivity(intent1);
        });

        q5Check.setOnClickListener(v->{
            int selectedId = q5radioGroup.getCheckedRadioButtonId(); // Get the ID of the selected RadioButton

            if (selectedId != -1) { // Check if any button is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();

                // Instead of if it's just checking the answer value
                Utils.AnswerQuestion(this,q5score,q5NextButton,q5radioGroup,q5Check, selectedText.equals(CorrectAnswer),questionNumber,CorrectAnswer);

            } else {
                Toast.makeText(this, "No selection made", Toast.LENGTH_SHORT).show();
            }
        });
    }
}