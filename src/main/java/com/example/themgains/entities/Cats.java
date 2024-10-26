package com.example.themgains.entities;

public abstract class Cats {

    public int img;
    public int displayImg;

    public int str;
    public int def;
    public int speed;

    public Rarities rarity;
    public Element element;

    public String name;
    public Cats(String name, Rarities rarity,Element element) {
        this.name = name;
        this.rarity = rarity;
        this.element = element;
    }

    public abstract void passives(Cats enemy);

}
