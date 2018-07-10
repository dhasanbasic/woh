package de.disoft.wor.domain.game;

import de.disoft.wor.domain.event.EventListener;
import de.disoft.wor.domain.event.EventType;
import de.disoft.wor.domain.event.GameEvent;
import de.disoft.wor.service.WoREventLane;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Battle implements EventListener {
    private Map<Player, List<HeroAssignment>> heroAssignmentsByPlayer;

    public Battle(int numPlayers) {
        heroAssignmentsByPlayer = new LinkedHashMap<>(numPlayers);
    }

    @Override
    public Battle register(WoREventLane eventLane) {
        eventLane.register(EventType.GameAddPlayer, this::onAddPlayer);
        eventLane.register(EventType.PlayerAssignHero, this::onAssignHero);
        return this;
    }

    private void onAddPlayer(GameEvent event) {
        heroAssignmentsByPlayer.put(event.getData(Player.class), new ArrayList<>());
    }

    private void onAssignHero(GameEvent event) {
        heroAssignmentsByPlayer.get(event.getPlayer()).add(event.getData(HeroAssignment.class));
    }

}
