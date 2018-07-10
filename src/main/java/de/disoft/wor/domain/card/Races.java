package de.disoft.wor.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Races {

    private HashMap<String, Race> races = new HashMap<>();

    @JsonCreator
    public Races(@JsonProperty("races") List<Race> races) {
        races.forEach(race -> this.races.put(race.getName(), race));
    }

    public Collection<Race> getRaces() {
        return races.values();
    }

    public Race getRaceByName(String name) {
        return races.get(name);
    }

}
