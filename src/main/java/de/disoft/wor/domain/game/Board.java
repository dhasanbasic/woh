package de.disoft.wor.domain.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Player, List<HeroPlacement>> heroesByPlayer;

    public Board(int numPlayers) {
        heroesByPlayer = new LinkedHashMap<>(numPlayers);
    }

    public void addPlayer(Player player) {
        heroesByPlayer.put(player, new ArrayList<>());
    }

    public List<HeroPlacement> getHeroesForPlayer(Player player) {
        return heroesByPlayer.get(player);
    }
}
