package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GiftedHeroCard extends HeroCard implements HasAbility {
    private Ability ability;

    @JsonCreator
    public GiftedHeroCard(
            @JsonProperty("id")
                    String id,
            @JsonProperty("name")
                    String name,
            @JsonProperty("description")
                    String description,
            @JsonProperty("race")
                    String race,
            @JsonProperty("health")
                    int health,
            @JsonProperty("damage")
                    int damage,
            @JsonProperty("mana")
                    int mana,
            @JsonProperty("ability")
                    Ability ability) {
        super(id, name, description, race, health, damage, mana);
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
        return "\nGiftedHeroCard { " +
                ability.toString() + '\'' +
                "} " + super.toString();
    }
}
