package com.example.themgains;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CosmicActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    protected int[] cats = {
            R.drawable.cosmiccatdisplay,
            R.drawable.dimensionaldisplay,
            R.drawable.pedrodisplay,
            R.drawable.gonydisplay,
            R.drawable.titancatdisplay
    };
    protected int currentlyDisplaying = 0;

    ImageView displayImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmic);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.win);

        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        displayImg = findViewById(R.id.displayedImage);

        //================Buttons
        findViewById(R.id.nextCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentlyDisplaying + 1 <= cats.length - 1) {
                    currentlyDisplaying++;
                } else {
                    currentlyDisplaying = 0;
                }
                displayImg.setImageResource(cats[currentlyDisplaying]);
            }
        });

        findViewById(R.id.prevCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentlyDisplaying - 1 >= 0) {
                    currentlyDisplaying--;
                } else {
                    currentlyDisplaying = cats.length - 1;
                }
                displayImg.setImageResource(cats[currentlyDisplaying]);
            }
        });

        findViewById(R.id.cosmicGoBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}