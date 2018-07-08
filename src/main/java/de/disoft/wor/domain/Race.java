package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Race {
    private String name;
    private String description;
    private Ability ability;

    @JsonCreator
    public Race(
            @JsonProperty("name")
                    String name,
            @JsonProperty("description")
                    String description,
            @JsonProperty("ability")
                    Ability ability) {
        this.name = name;
        this.description = description;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Ability getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "race : { " + "name = '" + name + "', " + "description = '" + description + "', " + ability + " }";
    }
}