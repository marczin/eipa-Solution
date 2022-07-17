package pl.marcinrosol.eipa.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.marcinrosol.eipa.models.event.EventType;
import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.models.request.EipaRequestResult;
import pl.marcinrosol.eipa.services.TimestampService;
import pl.marcinrosol.eipa.services.EipaService;
import pl.marcinrosol.eipa.services.EventService;

import java.util.List;
import java.util.stream.Collectors;

@EnableScheduling
@Configuration
public class EipaDataFetcher {

    private final EipaService eipaService;
    private final TimestampService datesService;
    private final EventService eventService;

    public EipaDataFetcher(EipaService eipaService, TimestampService datesService, EventService eventService) {
        this.eipaService = eipaService;
        this.datesService = datesService;
        this.eventService = eventService;
    }

    @Scheduled(cron = "${event.crone.time}", zone = "${event.crone.zone}")
    public void eipaDataFetcher() {
        prepareAndSendData();
    }

    private void prepareAndSendData() {
        var latestTimestamp = datesService.getLatestTimestamp();
        var result = fetchEipaData();
        var filteredData = eipaService.filterNewestData(result.getData(), latestTimestamp);
        var body = eventService.prepareEventData(filteredData, EventType.STATUS_UPDATE);
        eventService.parseEventData(body);
    }

    private EipaRequestResult fetchEipaData() {
        var result = eipaService.fetchDynamicData();
        var timestamp = datesService.getHighestCollectionTimestamp(result.getData());
        datesService.insertNewTimestamp(timestamp);
        return result;
    }

}
