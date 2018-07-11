package de.disoft.wor.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {

    private String name;

    private String description;

    private String pattern;

    @JsonCreator
    public Ability(@JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("pattern") String pattern) {
        this.name = name;
        this.description = description;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "ability: { name: \"" + name + "\", description: \"" + description + "\", pattern: \"" + pattern + "\"}";
    }

}
