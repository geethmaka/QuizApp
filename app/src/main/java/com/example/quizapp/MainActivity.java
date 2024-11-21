package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button continue_button;
    Button leaderboard;
    EditText username;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        continue_button = findViewById(R.id.continue_button);
        leaderboard = findViewById(R.id.leaderboard);
        username = findViewById(R.id.usernameInput);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        db = new DatabaseHelper(MainActivity.this);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        // Set up the Toolbar as the ActionBar
        setSupportActionBar(toolbar);

        // Create the ActionBarDrawerToggle to link the DrawerLayout with the Toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int nav = findViewById(R.id.nav_home).getId();

                // Use if-else statements instead of switch
                if (item.getItemId() == R.id.nav_home) {
                    Intent profileIntent = new Intent(MainActivity.this, Leaderboard.class);
                    startActivity(profileIntent);
                } else if (item.getItemId() == R.id.references) {
                    Intent profileIntent = new Intent(MainActivity.this, References.class);
                    startActivity(profileIntent);
                } else if (item.getItemId() == R.id.resetData) {
                    Intent settingsIntent = new Intent(MainActivity.this, ResetData.class);
                    startActivity(settingsIntent);
                }

                drawerLayout.closeDrawers(); // Close the drawer after selection
                return true;
            }

        });

        // Continue Button OnClickListener
        continue_button.setOnClickListener(v -> {
            if (!username.getText().toString().isEmpty()) {
                int success = db.adduser(username.getText().toString());
                if (success==1) {
                    Intent intent = new Intent(MainActivity.this, Question1.class);
                    int userid = db.getIdByName(username.getText().toString());
                    GlobalData.getInstance().setUser(username.getText().toString());
                    GlobalData.getInstance().setId(userid);
                    startActivity(intent);
                } else if(success==-1){
                    new AlertDialog.Builder(this)
                            .setTitle("Confirmation") // Title of the dialog
                            .setMessage("This username is already taken! Are you sure you want to proceed?") // Message in the dialog
                            .setPositiveButton("Yes", (dialog, which) -> {
                                Intent intent = new Intent(MainActivity.this, Question1.class);
                                int userid = db.getIdByName(username.getText().toString());
                                GlobalData.getInstance().setUser(username.getText().toString());
                                GlobalData.getInstance().setId(userid);
                                startActivity(intent);
                            })
                            .setNegativeButton("No, Choose a different name", (dialog, which) -> {
                            })
                            .setCancelable(true) // Allow dismissal by touching outside
                            .show();

                }
                else {
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Username Cannot Be Empty!!!", Toast.LENGTH_SHORT).show();
            }
        });

        // Leaderboard Button OnClickListener
        leaderboard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Leaderboard.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle toggle button click
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
