package com.example.themgains.entities.cats;

import com.example.themgains.R;
import com.example.themgains.entities.Cats;
import com.example.themgains.entities.Element;
import com.example.themgains.entities.Rarities;

public class DimensionalCat extends Cats {

    protected Element tempElement;
    protected int rng(int max, int min) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public DimensionalCat() {
        super("Dimensional Cat", Rarities.Legendary, Element.Green);

        str = 7;
        def = 30;
        speed = 30;

        img = R.drawable.dimensional_cat;
        displayImg = R.drawable.dimensionaldisplay;
    }

    @Override
    public void passives(Cats enemy) {
        tempElement = this.element;

        if (rng(100, 0) < 50) {
            this.element = Element.Green;
        } else {
            if (rng(100, 0) < 50) {
                if (this.element == Element.Red) {
                    this.element = Element.Green;
                } else {
                    this.element = Element.Red;
                    this.str += 2;
                    this.def -= 2;
                }
            } else {
                if (this.element == Element.Blue) {
                    this.element = Element.Green;
                } else {
                    this.element = Element.Blue;
                    this.str -= 2;
                    this.def += 2;
                }
            }
        }

        if (tempElement != this.element) this.def++;
    }
}
