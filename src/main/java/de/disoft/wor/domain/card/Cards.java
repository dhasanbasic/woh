package de.disoft.wor.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Cards {

    private HashMap<String, Card> cards = new HashMap<>();

    @JsonCreator
    public Cards(@JsonProperty("cards") List<Card> cards) {
        cards.forEach(card -> this.cards.put(card.getId(), card));
    }

    public Collection<Card> getCards() {
        return cards.values();
    }

    public Card getCardById(String id) {
        return cards.get(id);
    }

}
