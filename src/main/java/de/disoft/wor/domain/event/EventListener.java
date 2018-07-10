package de.disoft.wor.domain.event;

import de.disoft.wor.service.WoREventLane;

public interface EventListener {

    EventListener register(WoREventLane eventLane);

}
