package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity4 extends AppCompatActivity {

    public WebView musicianWV;

    Musician musician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        musicianWV = findViewById(R.id.WebView);

        //Get the bundle information from within the intent.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        musician = (Musician) bundle.getSerializable("musician");
        musicianWV.loadUrl(musician.getUrl());
    }
}