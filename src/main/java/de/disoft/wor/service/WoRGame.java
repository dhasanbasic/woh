package de.disoft.wor.service;

import de.disoft.wor.domain.event.EventType;
import de.disoft.wor.domain.game.Battle;
import de.disoft.wor.domain.game.Board;
import de.disoft.wor.domain.game.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class WoRGame {
    private WoRConfiguration configuration;

    private WoREventLane eventLane;

    private List<Player> players;

    private Board board;

    private Battle battle;

    @PostConstruct
    protected void createGame() {
        players = new ArrayList<>(configuration.getNumPlayers());
        board = new Board(configuration.getNumPlayers()).register(eventLane);
        battle = new Battle(configuration.getNumPlayers()).register(eventLane);
    }

    public WoRConfiguration getConfiguration() {
        return configuration;
    }

    @Autowired
    public void setConfiguration(WoRConfiguration configuration) {
        this.configuration = configuration;
    }

    public WoREventLane getEventLane() {
        return eventLane;
    }

    @Autowired
    public void setEventLane(WoREventLane eventLane) {
        this.eventLane = eventLane;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Battle getBattle() {
        return battle;
    }

    public void addPlayer(Player player) {
        players.add(player);
        eventLane.put(EventType.GameAddPlayer, player);
    }
}
