package com.example.themgains.entities.cats;

//Florin

import com.example.themgains.R;
import com.example.themgains.entities.Cats;
import com.example.themgains.entities.Element;
import com.example.themgains.entities.Rarities;

public class TitanCat extends Cats {

    protected boolean getHit = true;


    public TitanCat() {
        super("Titan Cat", Rarities.Rare, Element.Green);
        str = 3;
        def = 10;
        speed = 26;

        img = R.drawable.titancat;
    }

    @Override
    public void passives(Cats enemy) {
        if (enemy.element == Element.Red && getHit){
            def += 8;
            speed -= 2;
            getHit = false;
        }

    }
}