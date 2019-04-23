package com.example.gamal.backingapp.UI.MainActivity;


import android.os.Bundle;

import com.example.gamal.backingapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opening);
    }

}
