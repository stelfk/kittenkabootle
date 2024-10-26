package com.example.themgains.entities;

import com.example.themgains.entities.cats.CosmicCat;
import com.example.themgains.entities.cats.NoneCat;
import com.example.themgains.entities.cats.Pedro;
import com.example.themgains.entities.player.Player;

import java.util.ArrayList;
import java.util.List;

public class CatsHandler {

    protected List<Cats> cats = new ArrayList<>();

    public void add(Cats c) {
        cats.add(c);
    }

    public void remove(Cats c) {
        cats.remove(c);
    }

    public void implement() {
        add(new Pedro());
        add(new CosmicCat());
    }

    public int elementCase(Cats c1, Cats c2) {
        if ((c1.element == Element.Red && c2.element == Element.Green) || (c1.element == Element.Green && c2.element == Element.Blue) || (c1.element == Element.Blue && c2.element == Element.Red)) {
            return 1;
        } else if ((c2.element == Element.Red && c1.element == Element.Green) || (c2.element == Element.Green && c1.element == Element.Blue) || (c2.element == Element.Blue && c1.element == Element.Red)) {
            return 2;
        }
        return 0;
    }

    public void battleLoop(Player plr, Player plrE) {
        boolean finished = false;
        while (!finished) {
            if (plr.currentCard.speed > plrE.currentCard.speed) {
                plr.currentCard.passives(plrE.currentCard);
                plrE.currentCard.passives(plr.currentCard);
            } else {
                plrE.currentCard.passives(plr.currentCard);
                plr.currentCard.passives(plrE.currentCard);
            }

            switch (elementCase(plr.currentCard, plrE.currentCard)) {
                case 1:
                    plr.currentCard.str++;
                    plrE.currentCard.str--;
                    break;
                case 2:
                    plrE.currentCard.str++;
                    plr.currentCard.str--;
                    break;
            }
            //=======================================================================

            if (plr.currentCard.speed > plrE.currentCard.speed) {
                plrE.currentCard.def -= plr.currentCard.str;
                if (plrE.currentCard.def > 0) plr.currentCard.def -= plrE.currentCard.str;
            }else if (plrE.currentCard.speed > plr.currentCard.speed) {
                plr.currentCard.def -= plrE.currentCard.str;
                if (plr.currentCard.def > 0) plrE.currentCard.def -= plr.currentCard.str;
            } else {
                plrE.currentCard.def -= plr.currentCard.str;
                plr.currentCard.def -= plrE.currentCard.str;
            }

            //=======================================================================
            switch (elementCase(plr.currentCard, plrE.currentCard)) {
                case 1:
                    plrE.currentCard.str++;
                    plr.currentCard.str--;
                    break;
                case 2:
                    plr.currentCard.str++;
                    plrE.currentCard.str--;
                    break;
            }

            System.out.println(plr.currentCard.name + "\nHp:" + plr.currentCard.def + "\n\n\n");
            System.out.println(plrE.currentCard.name + "\nHp:" + plrE.currentCard.def + "\n");
            if (plr.currentCard.def <= 0) plr.currentCard = new NoneCat();
            if (plrE.currentCard.def <= 0) plrE.currentCard = new NoneCat();
            System.out.println("==============================================");
            if (plr.currentCard.def <= 0 || plrE.currentCard.def <= 0) finished = true;
            finished = true; //remove this to finish the battle in one go
        }
    }

}
