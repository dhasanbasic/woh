package de.disoft.wor.domain.game;

import de.disoft.wor.domain.HeroCard;
import de.disoft.wor.domain.WeaponCard;

public class HeroPlacement {
    private Player player;

    private HeroCard heroCard;

    private WeaponCard weaponCard;

    private int health;

    private int damage;

    private int mana;

    private boolean hasWeapon;

    private String weaponAbility;

    public Player getPlayer() {
        return player;
    }

    public void setHeroCard(Player player, HeroCard heroCard) {
        this.player = player;
        this.heroCard = heroCard;
        health = heroCard.getHealth();
        damage = heroCard.getDamage();
        mana = heroCard.getMana();
    }

    public void setWeaponCard(WeaponCard weaponCard) {
        this.weaponCard = weaponCard;
        hasWeapon = (weaponCard != null);
        weaponAbility = hasWeapon ? weaponCard.getAbilityValue() : null;
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
