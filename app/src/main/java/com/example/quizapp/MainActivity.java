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
                    Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.nav_profile) {
                    Intent profileIntent = new Intent(MainActivity.this, Leaderboard.class);
                    startActivity(profileIntent);
                } else if (item.getItemId() == R.id.nav_settings) {
                    Intent settingsIntent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(settingsIntent);
                }

                drawerLayout.closeDrawers(); // Close the drawer after selection
                return true;
            }

        });

        // Continue Button OnClickListener
        continue_button.setOnClickListener(v -> {
            if (!username.getText().toString().isEmpty()) {
                boolean success = db.adduser(username.getText().toString());
                if (success) {
                    Intent intent = new Intent(MainActivity.this, Question1.class);
                    GlobalData.getInstance().setUser(username.getText().toString());
                    startActivity(intent);
                } else {
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
