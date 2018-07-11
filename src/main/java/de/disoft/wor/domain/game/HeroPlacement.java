package de.disoft.wor.domain.game;

import de.disoft.wor.domain.card.Card;
import de.disoft.wor.service.util.exceptions.PlacementException;
import de.disoft.wor.service.util.exceptions.ValidatorException;
import de.disoft.wor.service.validator.CardValidator;

public class HeroPlacement {

    private Player player;

    private Card heroCard;

    private Card weaponCard;

    public HeroPlacement(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getHeroCard() {
        return heroCard;
    }

    public void setHeroCard(Card heroCard) throws PlacementException {
        try {
            if (CardValidator.isHeroCard(heroCard)) {
                this.heroCard = heroCard;
            }
        } catch (ValidatorException ve) {
            throw new PlacementException("Hero card cannot be placed.", ve);
        }
    }

    public Card getWeaponCard() {
        return weaponCard;
    }

    public void setWeaponCard(Card weaponCard) throws PlacementException {
        try {
            if (CardValidator.isWeaponCard(weaponCard)) {
                this.weaponCard = weaponCard;
            }
        } catch (ValidatorException ve) {
            throw new PlacementException("Weapon card cannot be placed.", ve);
        }
    }

    @Override
    public String toString() {
        return "heroPlacement: { " + player + ", " + heroCard + (weaponCard != null ? ", " + weaponCard : "") + " }";
    }

}
