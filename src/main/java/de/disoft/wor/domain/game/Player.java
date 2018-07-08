package de.disoft.wor.domain.game;

import java.util.ArrayList;
import java.util.List;

import de.disoft.wor.domain.AbstractCard;

public class Player {
    private String name;

    private List<AbstractCard> deck;

    private List<AbstractCard> hand;

    private int lifePoints;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        deck = new ArrayList<>();
        hand = new ArrayList<>();
    }

    public void resetPlayer(int lifePoints) {
        hand.clear();
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public void setDeck(List<AbstractCard> deck) {
        this.deck = deck;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
