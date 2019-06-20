package de.disoft.wor.domain.card;

import de.disoft.wor.util.enumeration.CardType;

public class WeaponCard extends AbstractCard {

    private CardType type;
    private String spell;

    public WeaponCard(Integer id, String name, String description, CardType type, String spell) {
        super(id, name, description);
        this.type = type;
        this.spell = spell;
    }

    @Override
    public CardType getType() {
        return type;
    }

    public String getSpell() {
        return spell;
    }

}
