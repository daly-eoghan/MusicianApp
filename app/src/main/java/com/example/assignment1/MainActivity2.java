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

public class MainActivity2 extends AppCompatActivity {

    public TextView nameTV, bandTV, roleTV;
    public ImageView musicianIV;
    public Button act3Btn, act4Btn;
    public ProgressBar progressBar;

    public int progressBarStatus = 0;
    public Musician musician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Link widgets with objects.
        nameTV = findViewById(R.id.NameTextView);
        bandTV = findViewById(R.id.BandTextView);
        roleTV = findViewById(R.id.RoleTextView);
        musicianIV = findViewById(R.id.MusicianImageView);
        act3Btn = findViewById(R.id.Act3Button);
        act4Btn = findViewById(R.id.Act4Button);
        progressBar = findViewById(R.id.progressBar1);
        progressBar.setProgress(0);

        //Get the bundle information from within the intent.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        musician = (Musician) bundle.getSerializable("musician");
        nameTV.setText(musician.getName());
        bandTV.setText(musician.getBand());
        roleTV.setText(musician.getRole());
        String imageName = musician.getImage();
        musicianIV.setImageResource(this.getResources().getIdentifier(imageName, "drawable", this.getPackageName()));
    }

    public void launchThirdActivity(View view) {
        // What you do when you click the More Info Button

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
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        Bundle bundle =  new Bundle();
        bundle.putSerializable("musician", musician);

        // Attach the bundle to the intent.
        intent.putExtras(bundle);

        startActivity(intent);


    }

    public void launchFourthActivity(View view) {
        // What you do when you click the Web Info Button.

        while (progressBarStatus < 100) {
            try {
                Thread.sleep(15);
                progressBarStatus++;
                progressBar.setProgress(progressBarStatus);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Intent intent = new Intent(this, MainActivity4.class);
        Bundle bundle =  new Bundle();
        bundle.putSerializable("musician", musician);

        // Attach the bundle to the intent.
        intent.putExtras(bundle);
        startActivity(intent);

    }
}