package de.disoft.wor.domain.game;

import de.disoft.wor.domain.event.EventListener;
import de.disoft.wor.domain.event.EventType;
import de.disoft.wor.domain.event.GameEvent;
import de.disoft.wor.service.WoREventLane;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Board implements EventListener {
    private Map<Player, List<HeroPlacement>> heroesByPlayer;

    public Board(int numPlayers) {
        heroesByPlayer = new LinkedHashMap<>(numPlayers);
    }

    @Override
    public Board register(WoREventLane eventLane) {
        eventLane.register(EventType.GameAddPlayer, this::onAddPlayer);
        eventLane.register(EventType.PlayerPlaceHero, this::onAddPlacement);
        return this;
    }

    public List<HeroPlacement> getHeroesByPlayer(Player player) {
        return heroesByPlayer.get(player);
    }

    private void onAddPlayer(GameEvent event) {
        heroesByPlayer.put(event.getData(Player.class), new ArrayList<>());
    }

    private void onAddPlacement(GameEvent event) {
        heroesByPlayer.get(event.getPlayer()).add(event.getData(HeroPlacement.class));
    }

}
