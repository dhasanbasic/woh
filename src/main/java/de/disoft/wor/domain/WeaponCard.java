package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeaponCard extends AbstractCard implements HasAbility {
    private Ability ability;

    @JsonCreator
    public WeaponCard(
            @JsonProperty("id")
                    String id,
            @JsonProperty("name")
                    String name,
            @JsonProperty("description")
                    String description,
            @JsonProperty("ability")
                    Ability ability) {
        super(id, name, description);
        this.ability = ability;
    }

    @Override
    public String getAbilityName() {
        return ability.getName();
    }

    @Override
    public String getAbilityDescription() {
        return ability.getDescription();
    }

    @Override
    public String getAbilityValue() {
        return ability.getValue();
    }

    @Override
    public String toString() {
        return "\nWeaponCard { " +
                ability.toString() + '\'' +
                "} " + super.toString();
    }
}
