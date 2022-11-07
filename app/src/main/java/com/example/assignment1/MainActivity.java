package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    public RecyclerView recyclerView = null;
    public DataAdapter adapter = null;
    public MusicianFromXml musicians = null;
    public ProgressBar progressBar;
    public Switch modeSwitch;
    public int progressBarStatus = 0;
    public boolean darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup recyclerView
        recyclerView = findViewById(R.id.recycleView);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(0);

        modeSwitch = findViewById(R.id.modeSwitch);

        darkMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        modeSwitch.setChecked(darkMode);

        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        musicians = new MusicianFromXml(this);

        // make adapter for it
        adapter = new DataAdapter(this, R.layout.row_layout, musicians.getMusicians(), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position){
        // What you do when you click a list item
        // Make an intent, place the bundle within and start activity
        while (progressBarStatus < 100) {
            try {
                Thread.sleep(15);
                progressBarStatus++;
                progressBar.setProgress(progressBarStatus);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Intent intent = new Intent(this, MainActivity2.class);

        // Get the data associated with position
        Musician musician = musicians.getMusician(position);
        Bundle bundle =  new Bundle();
        bundle.putSerializable("musician", musician);

        // Attach the bundle to the intent.
        intent.putExtras(bundle);

        startActivity(intent);

    }
}