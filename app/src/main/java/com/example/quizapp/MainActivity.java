package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button continue_button;
    Button leaderboard;
    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        continue_button=findViewById(R.id.continue_button);
        leaderboard = findViewById(R.id.leaderboard);
        username=findViewById(R.id.usernameInput);
        db = new DatabaseHelper(MainActivity.this);

        continue_button.setOnClickListener(v-> {
            if(!username.getText().toString().isEmpty()){
                boolean success= db.adduser(username.getText().toString());
                if(success){
                    Intent intent = new Intent(MainActivity.this, Question1.class);
                    GlobalData.getInstance().setUser(username.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Username Cannot Be Empty!!!", Toast.LENGTH_SHORT).show();
            }

                }
        );

        leaderboard.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, Leaderboard.class);
            startActivity(intent);
        });

    }
}