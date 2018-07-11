package de.disoft.wor.service.validator;

import de.disoft.wor.domain.card.Card;
import de.disoft.wor.domain.card.type.CardType;
import de.disoft.wor.service.util.exceptions.ValidatorException;

public final class CardValidator {

    private CardValidator() {
    }

    private static void cardNotNull(Card card) throws ValidatorException {
        if (card == null) {
            throw new ValidatorException("Card must not be null.");
        }
    }

    private static void cardTypeNotNull(Card card) throws ValidatorException {
        if (card.getType() == null) {
            throw new ValidatorException("Card type must not be null.");
        }
    }

    public static boolean isHeroCard(Card card) throws ValidatorException {
        cardNotNull(card);
        cardTypeNotNull(card);
        return card.getType().equals(CardType.NormalHeroCard.toString()) || card.getType().equals(CardType.GiftedHeroCard.toString());
    }

    public static boolean isWeaponCard(Card card) {
        cardNotNull(card);
        cardTypeNotNull(card);
        return card.getType().equals(CardType.WeaponCard.toString());
    }

}
