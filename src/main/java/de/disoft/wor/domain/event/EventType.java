package de.disoft.wor.domain.event;

public enum EventType {

    // game events
    GameStart(true),
    GameAddPlayer(true),
    GameEnterPlacementPhase(true),
    GameLeavePlacementPhase(true),
    GameEnterAssignmentPhase(true),
    GameLeaveAssignmentPhase(true),
    GameEnterBattlePhase(true),
    GameLeaveBattlePhase(true),
    GameEnd(true),

    // player events
    PlayerDrawCard,
    PlayerPlaceHero,
    PlayerPlaceWeapon,
    PlayerAssignHero;

    private boolean systemEvent;

    EventType(boolean systemEvent) {
        this.systemEvent = systemEvent;
    }

    EventType() {
        this.systemEvent = false;
    }

    public boolean isSystemEvent() {
        return systemEvent;
    }
}
