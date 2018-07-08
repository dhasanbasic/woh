package de.disoft.wor.service;

import de.disoft.wor.domain.Cards;
import de.disoft.wor.domain.Race;
import de.disoft.wor.domain.Races;
import de.disoft.wor.service.loader.CardLoader;
import de.disoft.wor.service.loader.RaceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class WoRConfiguration {
    private Races races;
    private Cards cards;

    private WoRConfiguration() {
    }

    @PostConstruct
    protected void loadConfiguration() {
        races = RaceLoader.getRaces();
        cards = CardLoader.getCards();
    }

    public Races getRaces() {
        return races;
    }

    public Cards getCards() {
        return cards;
    }
}
