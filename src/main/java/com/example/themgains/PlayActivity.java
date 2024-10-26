package com.example.themgains;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.CatsHandler;
import com.example.themgains.entities.cats.NoneCat;
import com.example.themgains.entities.player.Player;

public class PlayActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    MediaPlayer hitSound1;
    MediaPlayer hitSound2;

    private SoundPool soundPool;
    private int win;
    private int lose;

    public CatsHandler catsHandler = new CatsHandler();
    protected boolean viewsPlayer = true;

    ImageView plrImg;

    Intent intent;

    TextView hpText;
    TextView atkText;

    public Player plr;
    public Player plrE;

    protected boolean won = false;
    protected boolean lost = false;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        catsHandler.implement();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        hitSound1 = MediaPlayer.create(getApplicationContext(), R.raw.hit);
        hitSound2 = MediaPlayer.create(getApplicationContext(), R.raw.hit1);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.battlemusic);

        mediaPlayer.setLooping(true);
        mediaPlayer.start();



        hpText = findViewById(R.id.TextViewHp);
        atkText = findViewById(R.id.TextViewAtk);

        plrImg = findViewById(R.id.currentCard);

        plr = new Player();
        plrE = new Player();

        plrE.currentCard = plrE.cardsInDeck.get(0);
        plrE.cardsInDeck.remove(0);

        Button btnFight = findViewById(R.id.fightButton);
        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FIGHT(view);
            }
        });

        Button btnSwitchView = findViewById(R.id.toggleBetweenViewButton);
        btnSwitchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewsPlayer) {
                    plrImg.setImageResource(plrE.currentCard == new NoneCat() ? null : plrE.currentCard.img);
                    hpText.setText("Hp: " + plrE.currentCard.def);
                    atkText.setText("Str: " + plrE.currentCard.str);

                    btnSwitchView.setText("PLAYER");
                    viewsPlayer = false;
                } else {
                    plrImg.setImageResource(plr.currentCard == new NoneCat() ? null : plr.currentCard.img);
                    hpText.setText("Hp: " + plr.currentCard.def);
                    atkText.setText("Str: " + plr.currentCard.str);

                    btnSwitchView.setText("ENEMY");
                    viewsPlayer = true;
                }
            }
        });

    }

    protected int rng(int max, int min) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public void FIGHT(View view) {
        if (plr.currentCard.name == new NoneCat().name) {
            if (plr.cardsInDeck.size() <= 0) {
                lost = true;
            } else {
                System.out.println("You aint got a card you monkey!");
            }
        } else if (plrE.currentCard.name == new NoneCat().name) {
            if (plrE.cardsInDeck.size() > 0) {
                plrE.currentCard = plrE.cardsInDeck.get(0);
                plrE.cardsInDeck.remove(0);
                /*if (rng(100, 0) > 50) hitSound1.start();
                else hitSound2.start();*/
                catsHandler.battleLoop(plr, plrE);
            } else {
                won = true;
                System.out.println("You won nice, idc though");
            }
        } else {
            /*if (rng(100, 0) > 50) hitSound1.start();
            else hitSound2.start();*/
            catsHandler.battleLoop(plr, plrE);
        }
        if (viewsPlayer) {
            plrImg.setImageResource(plr.currentCard == new NoneCat() ? null : plr.currentCard.img);
            hpText.setText("Hp: " + plr.currentCard.def);
            atkText.setText("Str: " + plr.currentCard.str);
        } else {
            plrImg.setImageResource(plrE.currentCard == new NoneCat() ? null : plrE.currentCard.img);
            hpText.setText("Hp: " + plrE.currentCard.def);
            atkText.setText("Str: " + plrE.currentCard.str);
        }

        if (plr.currentCard == new NoneCat() && plr.cardsInDeck.size() <= 0) lost = true;
        if (plrE.currentCard == new NoneCat() && plrE.cardsInDeck.size() <= 0) won = true;

        if (won) {
            mediaPlayer.stop();
            intent = new Intent(getApplicationContext(), WinActivity.class);
            startActivity(intent);
        } else if (lost) {
            mediaPlayer.stop();
            intent = new Intent(getApplicationContext(), LostActivity.class);
            startActivity(intent);
        }
    }

    public void drawCard(View view) {
        System.out.println("======================================");
        System.out.println("> Button clicked");
        System.out.println("> Attempting to draw card...");

        if (plr.canDraw()) {
            i = (int)Math.floor(Math.random() * (plr.cardsInDeck.size() - 0 + 1) + 0);
            plr.currentCard = plr.cardsInDeck.get(0);

            System.out.println("> Drawn card: " + plr.cardsInDeck.get(0).name);
            plr.cardsInDeck.remove(0);

            System.out.println("> Printing deck(" + plr.cardsInDeck.size() + "): ");
            for (Cats c : plr.cardsInDeck) System.out.println("● " + c.name);
        } else {
            System.out.println("> Can't draw card...");
        }
        System.out.println("======================================");
        if (viewsPlayer) {
            plrImg.setImageResource(plr.currentCard == new NoneCat() ? null : plr.currentCard.img);
            hpText.setText("Hp: " + plr.currentCard.def);
            atkText.setText("Str: " + plr.currentCard.str);
        } else {
            plrImg.setImageResource(plrE.currentCard == new NoneCat() ? null : plrE.currentCard.img);
            hpText.setText("Hp: " + plrE.currentCard.def);
            atkText.setText("Str: " + plrE.currentCard.str);
        }
    }
}