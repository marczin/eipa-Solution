package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.dao.DynamicDataDao;
import pl.marcinrosol.eipa.models.events.EipaEvent;
import pl.marcinrosol.eipa.models.events.EventType;

import java.util.Collection;
import java.util.List;

public interface EventService {

    List<EipaEvent> prepareEventData(Collection<DynamicDataDao> dataCollection, EventType eventType);
}
