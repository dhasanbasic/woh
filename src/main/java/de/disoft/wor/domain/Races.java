package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Races {
    private HashMap<String, Race> allRaces;

    @JsonCreator
    public Races(
            @JsonProperty("allRaces")
                    List<Race> allRaces) {
        init(allRaces);
    }

    private void init(List<Race> allRaces) {
        this.allRaces = new HashMap<>();
        allRaces.stream().filter(Objects::nonNull).forEach(race -> this.allRaces.put(race.getName(), race));
    }

    public Collection<Race> getAll() {
        return allRaces.values();
    }

    public Race getRaceByName(String name) {
        return allRaces.get(name);
    }
}
