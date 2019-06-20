package de.disoft.wor.domain.card;

import de.disoft.wor.util.enumeration.CardType;

public class NormalHeroCard extends AbstractCard {

    private Integer health;
    private Integer attack;
    private Integer defense;

    public NormalHeroCard(Integer id, String name, String description, Integer health, Integer attack, Integer defense) {
        super(id, name, description);
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public CardType getType() {
        return CardType.NORMAL_HERO;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

}
