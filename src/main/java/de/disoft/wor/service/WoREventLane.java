package de.disoft.wor.service;

import de.disoft.wor.domain.event.EventData;
import de.disoft.wor.domain.event.EventType;
import de.disoft.wor.domain.event.GameEvent;
import de.disoft.wor.domain.game.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
@Scope("prototype")
public class WoREventLane {

    private final Logger logger = LoggerFactory.getLogger(WoREventLane.class);

    private Map<EventType, List<Consumer<GameEvent>>> listenersByEventType;

    protected WoREventLane() {
        listenersByEventType = new HashMap<>();
    }

    public void register(EventType type, Consumer<GameEvent> eventConsumer) {
        listenersByEventType.computeIfAbsent(type, event -> new ArrayList<>());
        listenersByEventType.get(type).add(eventConsumer);
    }

    public void put(EventType type, EventData data) {
        put(type, null, data);
    }

    public void put(EventType type, Player player, EventData data) {
        GameEvent event = new GameEvent(type, player, data);
        alertListeners(type, event);
    }

    private void alertListeners(EventType type, final GameEvent event) {
        if (listenersByEventType.containsKey(type)) {
            List<Consumer<GameEvent>> listeners = listenersByEventType.get(type);
            if (!listeners.isEmpty()) {
                logger.info("Publishing event: {}", event.getType());
                listeners.forEach(eventConsumer -> {
                    logger.info("Receiving event: {}, consumer: {}", event.getType(), eventConsumer);
                    eventConsumer.accept(event);
                });
            }
        }
    }

}
