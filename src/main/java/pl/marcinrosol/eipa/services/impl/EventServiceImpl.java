package pl.marcinrosol.eipa.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.marcinrosol.eipa.models.event.DynamicData;
import pl.marcinrosol.eipa.models.event.EipaEvent;
import pl.marcinrosol.eipa.models.event.EventType;
import pl.marcinrosol.eipa.models.event.Status;
import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.models.request.StatusDao;
import pl.marcinrosol.eipa.models.response.EventDataResponse;
import pl.marcinrosol.eipa.services.EventService;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Value("${event.response.post.url}")
    private String POST_URL;

    @Override
    public EventDataResponse prepareEventData(Collection<DynamicDataDao> dataCollection, EventType eventType) {
        var eipaEvents =  dataCollection.stream()
                .map(this::buildDynamicData)
                 .map(dynamicData -> prepareEvent(eventType, dynamicData) )
                .collect(Collectors.toList());
        return new EventDataResponse(eipaEvents);
    }

    private DynamicData buildDynamicData(DynamicDataDao data) {
        return DynamicData.builder()
                .status(prepareStatus(data.getStatus()))
                .pointId(data.getCode())
                .originalTs(data.getStatus().getTs())
                .build();
    }

    private Status prepareStatus(StatusDao statusDao) {
        Status result = Status.UNKNOWN;
        if (statusDao.getAvailability() == 0) {
            result = Status.OUT_OF_ORDER;
        } else if (statusDao.getStatus() == 1) {
            result = Status.AVAILABLE;
        } else if (statusDao.getStatus() == 0) {
            result = Status.OCCUPIED;
        }
        return result;
    }

    private EipaEvent prepareEvent(EventType eventType, DynamicData data) {
        String uuid = UUID.randomUUID().toString();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return new EipaEvent(uuid, timestamp, eventType, data);
    }

    @Override
    public HttpStatus parseEventData(EventDataResponse body) {
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.postForEntity(POST_URL, body, EventDataResponse.class );
        return result.getStatusCode();
    }

}
