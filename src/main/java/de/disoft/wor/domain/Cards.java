package de.disoft.wor.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cards {
    private List<HeroCard> normalHeroes;

    private List<GiftedHeroCard> giftedHeroes;

    private List<WeaponCard> weapons;

    private Map<String, AbstractCard> allCards;

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
        normalHeroes.stream().forEach(c -> allCards.put(c.getId(), c));
        giftedHeroes.stream().forEach(c -> allCards.put(c.getId(), c));
        weapons.stream().forEach(c -> allCards.put(c.getId(), c));
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
