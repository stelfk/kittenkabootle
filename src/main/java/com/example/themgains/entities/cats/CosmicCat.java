package com.example.themgains.entities.cats;

import com.example.themgains.R;
import com.example.themgains.entities.Cats;
import com.example.themgains.entities.Element;
import com.example.themgains.entities.Rarities;

public class CosmicCat extends Cats {
    public CosmicCat() {
        super("Cosmic Cat", Rarities.Legendary, Element.White);
        str = 1;
        def = 40;
        speed = 25;

        img = R.drawable.cosmic_cat;
        displayImg = R.drawable.cosmiccatdisplay;
    }

    @Override
    public void passives(Cats enemy) {
        if (enemy.element == Element.Red) {
            element = Element.Blue;
        } else if (enemy.element == Element.Green) {
            element = Element.Red;
        } else if (enemy.element == Element.Blue) {
            element = Element.Green;
        }

        str += 1;
    }
}
