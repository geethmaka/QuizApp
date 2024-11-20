package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final_page);

        TextView grade = findViewById(R.id.gradeText);
        TextView username = findViewById(R.id.usernametxt);
        int mark = GlobalData.getInstance().getMark();
        username.setText(GlobalData.getInstance().getUser()+",");
        grade.setText(mark+"/5");

        Button home =findViewById(R.id.gotoHomePage);
        Button leaderBoard = findViewById(R.id.gotoLeaderboard);
        home.setOnClickListener(v->{
            GlobalData.getInstance().clearAllData();
            Intent intent1 = new Intent(FinalPage.this, MainActivity.class);
            startActivity(intent1);
        });

        leaderBoard.setOnClickListener(v->{
            GlobalData.getInstance().clearAllData();
            Intent intent1 = new Intent(FinalPage.this, Leaderboard.class);
            startActivity(intent1);
        });
    }
}