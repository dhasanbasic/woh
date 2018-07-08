package de.disoft.wor.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.disoft.wor.domain.Cards;
import de.disoft.wor.domain.Race;

@Component
public class WoRConfiguration {
    private HashMap<String, Race> races;

    private Cards cards;

    @Value("${wor.data.races}")
    private String racesJson;

    @Value("${wor.data.cards}")
    private String cardsJson;

    @Value("${wor.game.numPlayers}")
    private int numPlayers;

    @Value("${wor.game.lifePoints}")
    private int lifePoints;

    private WoRConfiguration() {

    }

    @PostConstruct
    protected void loadConfiguration() {
        races = loadRaces();
        loadCards();
    }

    private HashMap<String, Race> loadRaces() {
        TypeReference<List<Race>> raceTypeReference = new TypeReference<List<Race>>() {
        };
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Race> raceList = mapper.readValue(ClassLoader.getSystemResource(racesJson), raceTypeReference);
            return createRaceMap(raceList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HashMap<String, Race> createRaceMap(List<Race> raceList) {
        LinkedHashMap<String, Race> raceMap = new LinkedHashMap<>(raceList.size());
        for (Race race : raceList) {
            raceMap.put(race.getName(), race);
        }
        return raceMap;
    }

    private void loadCards() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.cards = mapper.readValue(ClassLoader.getSystemResource(cardsJson), Cards.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Race> getRaces() {
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
