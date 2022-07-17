package pl.marcinrosol.eipa.services;

import org.springframework.http.HttpStatus;
import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.models.response.EventDataResponse;
import pl.marcinrosol.eipa.models.event.EventType;

import java.util.Collection;

public interface EventService {

    EventDataResponse prepareEventData(Collection<DynamicDataDao> dataCollection, EventType eventType);

    HttpStatus parseEventData(EventDataResponse body);
}
