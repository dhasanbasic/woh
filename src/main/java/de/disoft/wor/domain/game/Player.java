package de.disoft.wor.domain.game;

import de.disoft.wor.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Card> deck = new ArrayList<>();

    private List<Card> hand = new ArrayList<>();

    private int lifePoints;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
    }

    public void resetPlayer(int lifePoints) {
        hand.clear();
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public String toString() {
        return "Player: { name = \"" + name + "\", lifePoints = " + lifePoints + " }";
    }

}
