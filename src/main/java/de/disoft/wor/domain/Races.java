package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Races {
    private HashMap<String, Race> allRaces;
    private List<Race> allRacesList;

    @JsonCreator
    public Races(
            @JsonProperty("allRaces")
                    List<Race> allRaces) {
        this.allRacesList = allRaces;
        init();
    }

    private void init() {
        allRaces = new HashMap<>();
        allRacesList.stream().filter(Objects::nonNull).forEach(race -> allRaces.put(race.getName(), race));
    }

    public Collection<Race> getAll() {
        return allRaces.values();
    }

    public Race getRaceByName(String name) {
        return allRaces.get(name);
    }
}
