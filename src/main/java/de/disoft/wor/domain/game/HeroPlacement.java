package de.disoft.wor.domain.game;

import de.disoft.wor.domain.card.HeroCard;
import de.disoft.wor.domain.card.WeaponCard;
import de.disoft.wor.domain.event.EventData;

public class HeroPlacement implements EventData {
    private Player player;
    private HeroCard heroCard;
    private WeaponCard weaponCard;

    private int health;
    private int damage;
    private int mana;

    public HeroPlacement(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public HeroCard getHeroCard() {
        return heroCard;
    }

    public void setHeroCard(HeroCard heroCard) {
        this.heroCard = heroCard;
        health = heroCard.getHealth();
        damage = heroCard.getDamage();
        mana = heroCard.getMana();
    }

    public WeaponCard getWeaponCard() {
        return weaponCard;
    }

    public void setWeaponCard(WeaponCard weaponCard) {
        this.weaponCard = weaponCard;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
