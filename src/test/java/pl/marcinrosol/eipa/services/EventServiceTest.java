package pl.marcinrosol.eipa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import pl.marcinrosol.eipa.models.event.EventType;
import pl.marcinrosol.eipa.models.event.Status;
import pl.marcinrosol.eipa.services.impl.EventServiceImpl;

@SpringBootTest
public class EventServiceTest extends TestData {

    @InjectMocks
    EventServiceImpl eventService;

    @Test
    void testEventDataPreparation() {
        var result = eventService.prepareEventData(prepareDataList(), EventType.STATUS_UPDATE);

        Assertions.assertNotNull(result);

        Assertions.assertNotNull(result.getEvents().get(0).getId());
        Assertions.assertNotNull(result.getEvents().get(1).getId());
        Assertions.assertNotNull(result.getEvents().get(2).getId());
        Assertions.assertNotNull(result.getEvents().get(0).getTs());
        Assertions.assertNotNull(result.getEvents().get(1).getTs());
        Assertions.assertNotNull(result.getEvents().get(2).getTs());
        Assertions.assertEquals(result.getEvents().get(0).getType(), EventType.STATUS_UPDATE);
        Assertions.assertEquals(result.getEvents().get(1).getType(), EventType.STATUS_UPDATE);
        Assertions.assertEquals(result.getEvents().get(2).getType(), EventType.STATUS_UPDATE);

        Assertions.assertEquals(result.getEvents().get(0).getData().getPointId(), UUID_1);
        Assertions.assertEquals(result.getEvents().get(1).getData().getPointId(), UUID_2);
        Assertions.assertEquals(result.getEvents().get(2).getData().getPointId(), UUID_3);
        Assertions.assertEquals(result.getEvents().get(0).getData().getStatus(), Status.AVAILABLE);
        Assertions.assertEquals(result.getEvents().get(1).getData().getStatus(), Status.OCCUPIED);
        Assertions.assertEquals(result.getEvents().get(2).getData().getStatus(), Status.OUT_OF_ORDER);
    }

    @Test
    void testEventDataPreparationWhenProvidedNullValues() {
        var result = eventService.prepareEventData(prepareNullDataList(), EventType.STATUS_UPDATE);

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getEvents().get(0).getId());
        Assertions.assertNotNull(result.getEvents().get(1).getId());
        Assertions.assertEquals(result.getEvents().get(0).getData().getPointId(), UUID_1);
        Assertions.assertEquals(result.getEvents().get(1).getData().getPointId(), UUID_2);
        Assertions.assertEquals(result.getEvents().get(0).getData().getStatus(), Status.UNKNOWN);
        Assertions.assertEquals(result.getEvents().get(1).getData().getStatus(), Status.UNKNOWN);
    }


}
