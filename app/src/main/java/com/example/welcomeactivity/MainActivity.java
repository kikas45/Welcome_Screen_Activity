package com.example.welcomeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_WelcomeActivity);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
    }
}