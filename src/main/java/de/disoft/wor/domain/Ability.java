package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {
    private String name;
    private String description;
    private String value;

    @JsonCreator
    public Ability(
            @JsonProperty("name")
                    String name,
            @JsonProperty("description")
                    String description,
            @JsonProperty("value")
                    String value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ability : { " +
                "name = '" + name + "', " +
                "description = '" + description + "', " +
                "value = '" + value + "'" +
                " } ";
    }
}
