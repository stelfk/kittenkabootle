package com.example.themgains.entities.player;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.cats.CosmicCat;
import com.example.themgains.entities.cats.DimensionalCat;
import com.example.themgains.entities.cats.Gony;
import com.example.themgains.entities.cats.NoneCat;
import com.example.themgains.entities.cats.Pedro;
import com.example.themgains.entities.cats.TitanCat;

import java.util.ArrayList;
import java.util.Collections;

public class Player {

    public ArrayList<Cats> cardsInDeck = new ArrayList<>();
    public ArrayList<Cats> notSuffledDeck = new ArrayList<>();
    public Cats currentCard;

    public Player() {
        fillDeck();
        currentCard = new NoneCat();
    }

    public void fillDeck() {
        cardsInDeck.add(new Pedro());
        cardsInDeck.add(new CosmicCat());
        cardsInDeck.add(new DimensionalCat());
        cardsInDeck.add(new Gony());
        cardsInDeck.add(new TitanCat());

        Collections.shuffle(cardsInDeck);
    }

    public boolean canDraw() {
        if (cardsInDeck.size() > 0 && currentCard.name == "None") {
            return true;
        }
        return false;
    }

}
