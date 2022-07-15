package pl.marcinrosol.eipa.services.impl;

import org.springframework.stereotype.Service;
import pl.marcinrosol.eipa.models.dao.DynamicDataDao;
import pl.marcinrosol.eipa.models.dao.StatusDao;
import pl.marcinrosol.eipa.models.events.EipaEvent;
import pl.marcinrosol.eipa.models.events.EventType;
import pl.marcinrosol.eipa.models.response.DynamicData;
import pl.marcinrosol.eipa.models.response.Status;
import pl.marcinrosol.eipa.services.EventService;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public List<EipaEvent> prepareEventData(Collection<DynamicDataDao> dataCollection, EventType eventType) {
         return dataCollection.stream()
                .map(this::buildDynamicData)
                 .map(dynamicData -> prepareEvent(eventType, dynamicData) )
                .collect(Collectors.toList());
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
        } else if (statusDao.getStatus() == 0){
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

}
