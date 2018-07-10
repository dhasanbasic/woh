package de.disoft.wor.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.disoft.wor.domain.card.Cards;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public final class CardLoader {

    private Cards cards;

    @Value("${wor.data.cards}")
    private String cardsJson;

    private CardLoader() {
    }

    @PostConstruct
    public void loadCards() {
        try {
            cards = new ObjectMapper().readValue(ClassLoader.getSystemResource(cardsJson), Cards.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Cards getCards() {
        return cards;
    }

}