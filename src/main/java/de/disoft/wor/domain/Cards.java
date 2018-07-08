package de.disoft.wor.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Cards {
    private List<HeroCard> normalHeroes;
    private List<GiftedHeroCard> giftedHeroes;
    private List<WeaponCard> weapons;
    private HashMap<String, AbstractCard> allCards;

    @JsonCreator
    public Cards(
            @JsonProperty("normalHeroes")
                    List<HeroCard> normalHeroes,
            @JsonProperty("giftedHeroes")
                    List<GiftedHeroCard> giftedHeroes,
            @JsonProperty("weapons")
                    List<WeaponCard> weapons) {
        this.normalHeroes = normalHeroes;
        this.giftedHeroes = giftedHeroes;
        this.weapons = weapons;
        init();
    }

    private void init() {
        allCards = new HashMap<>();
        normalHeroes.forEach(card -> allCards.put(card.getId(), card));
        giftedHeroes.forEach(card -> allCards.put(card.getId(), card));
        weapons.forEach(card -> allCards.put(card.getId(), card));
    }

    public List<HeroCard> getNormalHeroes() {
        return normalHeroes;
    }

    public List<GiftedHeroCard> getGiftedHeroes() {
        return giftedHeroes;
    }

    public List<WeaponCard> getWeapons() {
        return weapons;
    }

    public Collection<AbstractCard> getAll() {
        return allCards.values();
    }

    public AbstractCard getCardById(String id) {
        return allCards.get(id);
    }
}
