package de.disoft.wor.domain.game;

import de.disoft.wor.domain.event.EventData;

import java.util.List;

public class HeroAssignment implements EventData {
    private HeroPlacement sourceHero;

    private List<HeroPlacement> targetHeroes;

    private boolean useWeaponAbility;

    public HeroAssignment(HeroPlacement sourceHero, List<HeroPlacement> targetHeroes, boolean useWeaponAbility) {
        this.sourceHero = sourceHero;
        this.targetHeroes = targetHeroes;
        this.useWeaponAbility = useWeaponAbility;
    }

    public HeroPlacement getSourceHero() {
        return sourceHero;
    }

    public List<HeroPlacement> getTargetHeroes() {
        return targetHeroes;
    }

    public boolean isUseWeaponAbility() {
        return useWeaponAbility;
    }

}
