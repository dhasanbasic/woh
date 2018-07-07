package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeaponCard extends AbstractCard implements HasAbility {
    private String ability;

    @JsonCreator
    public WeaponCard(
            @JsonProperty("id")
                    String id,
            @JsonProperty("name")
                    String name,
            @JsonProperty("description")
                    String description,
            @JsonProperty("ability")
                    String ability) {
        super(id, name, description);
        this.ability = ability;
    }

    @Override
    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "WeaponCard{" +
                "ability='" + ability + '\'' +
                "} " + super.toString();
    }
}
