package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    public TextView nameTV, bandTV, roleTV, infoTV;
    public ImageView musicianIV;
    public Button act1Btn, act4Btn;
    public ProgressBar progressBar;

    public int progressBarStatus = 0;
    Musician musician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Link widgets with objects.
        nameTV = findViewById(R.id.NameTextView);
        bandTV = findViewById(R.id.BandTextView);
        roleTV = findViewById(R.id.RoleTextView);
        infoTV = findViewById(R.id.InfoTextView);
        musicianIV = findViewById(R.id.MusicianImageView);
        act1Btn = findViewById(R.id.Act1Button);
        act4Btn = findViewById(R.id.Act4Button);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);

        //Get the bundle information from within the intent.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        musician = (Musician) bundle.getSerializable("musician");
        nameTV.setText(musician.getName());
        bandTV.setText(musician.getBand());
        roleTV.setText(musician.getRole());
        infoTV.setText(musician.getInfo());
        String imageName = musician.getImage();
        musicianIV.setImageResource(this.getResources().getIdentifier(imageName, "drawable", this.getPackageName()));

    }

    public void launchFirstActivity(View view) {
        // What you do when you click the Home Page Button.

        //Update the progress bar.
        while (progressBarStatus < 100) {
            try {
                Thread.sleep(15);
                progressBarStatus++;
                progressBar.setProgress(progressBarStatus);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Make an intent, place the bundle within and start activity
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);

    }

    public void launchFourthActivity(View view) {
        // What you do when you click the Web Info Button.

        //Update the progress bar.
        while (progressBarStatus < 100) {
            try {
                Thread.sleep(15);
                progressBarStatus++;
                progressBar.setProgress(progressBarStatus);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Make an intent, place the bundle within and start activity
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("musician", musician);

        // Attach the bundle to the intent.
        intent.putExtras(bundle);

        startActivity(intent);
    }
}