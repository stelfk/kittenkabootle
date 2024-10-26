package com.example.themgains;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LostActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lose);

        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        Button btn = findViewById(R.id.goBackButton2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}