package de.disoft.wor.domain.card;

import de.disoft.wor.util.enumeration.CardType;

public class MagicHeroCard extends NormalHeroCard {

    private String spell;

    public MagicHeroCard(Integer id, String name, String description, Integer health, Integer attack, Integer defense, String spell) {
        super(id, name, description, health, attack, defense);
        this.spell = spell;
    }

    @Override
    public CardType getType() {
        return CardType.MAGIC_HERO;
    }

    public String getSpell() {
        return spell;
    }

}
