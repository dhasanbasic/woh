package de.disoft.wor.domain.card;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.disoft.wor.domain.card.type.CardType;

public class Card {

    private String type;

    private String id;

    private String name;

    private String description;

    private String raceName;

    private Race race;

    private Integer health;

    private Integer damage;

    private Integer mana;

    private Ability ability;

    @JsonCreator
    public Card(@JsonProperty("type") String type,
                @JsonProperty("id") String id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("raceName") String raceName,
                @JsonProperty("health") Integer health,
                @JsonProperty("damage") Integer damage,
                @JsonProperty("mana") Integer mana,
                @JsonProperty("ability") Ability ability) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.description = description;
        this.raceName = raceName;
        this.race = null;
        this.health = health;
        this.damage = damage;
        this.mana = mana;
        this.ability = ability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        if (type.equals(CardType.NormalHeroCard.toString())) {
            return "card: { type: \"" + type + "\", id: \"" + "\", name: \"" + name + "\", description: \"" + description + "\", " + race + ", health: " + health + ", damage: " + damage + ", mana: " + mana + " }";
        } else if (type.equals(CardType.GiftedHeroCard.toString())) {
            return "card: { type: \"" + type + "\", id: \"" + "\", name: \"" + name + "\", description: \"" + description + "\", " + race + ", health: " + health + ", damage: " + damage + ", mana: " + mana + ", " + ability + " }";
        } else {
            return "card: { type: \"" + type + "\", id: \"" + "\", name: \"" + name + "\", description: \"" + description + "\", " + ability + " }";
        }
    }

}