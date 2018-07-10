package de.disoft.wor.domain.event;

import de.disoft.wor.domain.game.Player;

public class GameEvent {

    private EventType type;
    private Player player;
    private EventData data;

    public GameEvent(EventType type, Player player, EventData data) {
        this.type = type;
        this.player = player;
        this.data = data;
    }

    public EventType getType() {
        return type;
    }

    public Player getPlayer() {
        return player;
    }

    public <T> T getData(Class<T> clazz) {
        if (clazz.isInstance(data)) {
            return clazz.cast(data);
        }
        throw new UnsupportedOperationException("GameEvent.getData: unsupported class - " + clazz.getSimpleName());
    }
}
