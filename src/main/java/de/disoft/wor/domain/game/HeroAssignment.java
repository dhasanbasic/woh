package de.disoft.wor.domain.game;

import java.util.List;

public class HeroAssignment {
    private HeroPlacement sourceHero;

    private List<HeroPlacement> targetHeroes;

    private boolean useWeaponAbility;

    public HeroAssignment(HeroPlacement sourceHero, List<HeroPlacement> targetHeroes, boolean useWeaponAbility) {
        this.sourceHero = sourceHero;
        this.targetHeroes = targetHeroes;
        this.useWeaponAbility = useWeaponAbility;
    }

}