package de.disoft.wor.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.disoft.wor.domain.Cards;

import java.io.IOException;

public final class CardLoader {
    private static final String CARDS_JSON = "data/cards.json";
    private static Cards cards = null;

    private CardLoader() {
    }

    public static Cards getCards() {
        if (cards == null) {
            loadCards();
        }
        return cards;
    }

    private static void loadCards() {
        try {
            cards = new ObjectMapper().readValue(ClassLoader.getSystemResource(CARDS_JSON), Cards.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}