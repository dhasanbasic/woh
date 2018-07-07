package de.disoft.wor.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.disoft.wor.domain.Cards;
import de.disoft.wor.domain.Race;

@Service
public class WoRConfiguration {
    private final static String RACES_JSON = "data/races.json";

    private final static String CARDS_JSON = "data/cards.json";

    private HashMap<String, Race> races;

    private Cards cards;

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
            List<Race> raceList = mapper.readValue(ClassLoader.getSystemResource(RACES_JSON), raceTypeReference);
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
            this.cards = mapper.readValue(ClassLoader.getSystemResource(CARDS_JSON), Cards.class);
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
}
