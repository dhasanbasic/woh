package de.disoft.wor.util.enumeration;

import de.disoft.wor.domain.card.AbstractCard;
import de.disoft.wor.domain.card.MagicHeroCard;
import de.disoft.wor.domain.card.NormalHeroCard;
import de.disoft.wor.domain.card.WeaponCard;

public enum CardType {

    NORMAL_HERO(NormalHeroCard.class),
    MAGIC_HERO(MagicHeroCard.class),
    NORMAL_WEAPON(WeaponCard.class),
    MAGIC_WEAPON(WeaponCard.class);

    private Class<? extends AbstractCard> cardClass;

    CardType(Class<? extends AbstractCard> cardClass) {
        this.cardClass = cardClass;
    }

    public Class<? extends AbstractCard> getCardClass() {
        return cardClass;
    }

}