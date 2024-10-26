package com.example.themgains.entities.cats;

import com.example.themgains.R;
import com.example.themgains.entities.Cats;
import com.example.themgains.entities.CatsHandler;
import com.example.themgains.entities.Element;
import com.example.themgains.entities.Rarities;

public class Gony extends Cats {

    protected boolean stayAlive = true;

    protected CatsHandler catsHandler = new CatsHandler();

    public Gony() {
        super("Gony", Rarities.Rare, Element.Blue);

        str = 4;
        def = 15;
        speed = 15;

        img = R.drawable.gony;
        displayImg = R.drawable.gonydisplay;
    }

    @Override
    public void passives(Cats enemy) {
        if (stayAlive) {
            if (catsHandler.elementCase(this, enemy) == 2) {
                if (this.def - (enemy.str + 1) <= 0) {
                    this.def += 2;
                    stayAlive = false;
                }
            } else {
                if (this.def - enemy.str <= 0) {
                    this.def += 1;
                    stayAlive = false;
                }
            }
        }
    }
}
