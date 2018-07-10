package de.disoft.wor.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.disoft.wor.domain.Ability;

public class WeaponCard extends AbstractCard {
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

    public Ability getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "\nWeaponCard { " + ability + " } " + super.toString();
    }
}