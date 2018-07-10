package de.disoft.wor.service;

import de.disoft.wor.domain.card.Cards;
import de.disoft.wor.domain.card.Races;
import de.disoft.wor.domain.card.type.CardType;
import de.disoft.wor.service.loader.CardLoader;
import de.disoft.wor.service.loader.RaceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WoRConfiguration {

    private Races races;

    private Cards cards;

    private RaceLoader raceLoader;

    private CardLoader cardLoader;

    @Value("${wor.game.numPlayers}")
    private int numPlayers;

    @Value("${wor.game.lifePoints}")
    private int lifePoints;

    private WoRConfiguration() {
    }

    @PostConstruct
    protected void loadConfiguration() {
        races = raceLoader.getRaces();
        cards = cardLoader.getCards();
        init(cards, races);
    }

    private void init(Cards cards, Races races) {
        cards.getCards().stream().filter(card -> !card.getType().equals(CardType.WeaponCard.toString())).forEach(card ->  card.setRace(races.getRaceByName(card.getRaceName())));
    }

    @Autowired
    public void setRaceLoader(RaceLoader raceLoader) {
        this.raceLoader = raceLoader;
    }

    @Autowired
    public void setCardLoader(CardLoader cardLoader) {
        this.cardLoader = cardLoader;
    }

    public Races getRaces() {
        return races;
    }

    public Cards getCards() {
        return cards;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getLifePoints() {
        return lifePoints;
    }

}
