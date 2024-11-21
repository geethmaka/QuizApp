package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quizapp.databinding.ActivityAboutUsBinding;
import com.example.quizapp.databinding.ActivityMainBinding;

public class AboutUs extends AppCompatActivity {

    ActivityAboutUsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new GeethFragment());

        binding.navigationView.setOnItemSelectedListener(item->{
            if (item.getItemId() == R.id.geethmakaNav) {
                replaceFragment(new GeethFragment());
            } else if (item.getItemId() == R.id.anojanNav) {
                replaceFragment(new AnojanFragment());
            } else if (item.getItemId() == R.id.aarjuNav) {
                replaceFragment(new AarjuFragment());
            }
            return true;
        });
    }


    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameAboutUs,fragment);
        fragmentTransaction.commit();

    }
}