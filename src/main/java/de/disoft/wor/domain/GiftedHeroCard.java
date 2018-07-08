package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.disoft.wor.service.loader.RaceLoader;

public class GiftedHeroCard extends HeroCard {
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

    public Ability getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "\nGiftedHeroCard { " + ability + " } " + super.toString();
    }

}
