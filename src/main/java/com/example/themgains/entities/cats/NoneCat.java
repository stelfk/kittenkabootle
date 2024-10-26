package com.example.themgains.entities.cats;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.Element;
import com.example.themgains.entities.Rarities;

public class NoneCat extends Cats {

    public NoneCat() {
        super("None", Rarities.Common, Element.Black);
    }

    @Override
    public void passives(Cats enemy) {

    }
}
