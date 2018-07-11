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

    public void addAssignment(Player player, HeroPlacement heroPlacement) {
        heroesByPlayer.get(player).add(heroPlacement);
    }

    public List<HeroPlacement> getHeroPlacementsForPlayer(Player player) {
        return heroesByPlayer.get(player);
    }

}
