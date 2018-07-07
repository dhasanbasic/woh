package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroCard extends AbstractCard {
    private Race race;

    private int health;

    private int damage;

    private int mana;

    @JsonCreator
    public HeroCard(
            @JsonProperty("id")
                    String id,
            @JsonProperty("name")
                    String name,
            @JsonProperty("description")
                    String description,
            @JsonProperty("race")
                    String race,
            @JsonProperty("health")
                    int health,
            @JsonProperty("damage")
                    int damage,
            @JsonProperty("mana")
                    int mana) {
        super(id, name, description);
        this.race = null;
        this.health = health;
        this.damage = damage;
        this.mana = mana;
    }

    public Race getRace() {
        return race;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return "\nHeroCard { " +
                "race = " + race +
                ", health = " + health +
                ", damage = " + damage +
                ", mana = " + mana +
                " } " + super.toString();
    }
}
