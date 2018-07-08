package de.disoft.wor.domain.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Battle {
    private Map<Player, List<HeroAssignment>> heroAssignmentsByPlayer;

    public Battle(int numPlayers) {
        heroAssignmentsByPlayer = new LinkedHashMap<>(numPlayers);
    }

    public void addPlayer(Player player) {
        heroAssignmentsByPlayer.put(player, new ArrayList<>());
    }
}
