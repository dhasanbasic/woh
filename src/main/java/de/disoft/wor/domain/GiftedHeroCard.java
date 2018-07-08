package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GiftedHeroCard extends HeroCard implements HasAbility {
    private String ability;

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
                    String ability) {
        super(id, name, description, race, health, damage, mana);
        this.ability = ability;
    }

    @Override
    public String getAbility() {
        return null;
    }

    @Override
    public String toString() {
        return "GiftedHeroCard{" +
                "ability='" + ability + '\'' +
                "} " + super.toString();
    }
}
