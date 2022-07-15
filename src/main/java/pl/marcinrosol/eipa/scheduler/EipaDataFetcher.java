package pl.marcinrosol.eipa.scheduler;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.marcinrosol.eipa.models.dao.EipaRequestResult;
import pl.marcinrosol.eipa.services.DatesService;
import pl.marcinrosol.eipa.services.EipaService;
import pl.marcinrosol.eipa.services.EventService;

@EnableScheduling
@Configuration
public class EipaDataFetcher {

    private final EipaService eipaService;
    private final DatesService datesService;
    private final EventService eventService;

    public EipaDataFetcher(EipaService eipaService, DatesService datesService, EventService eventService) {
        this.eipaService = eipaService;
        this.datesService = datesService;
        this.eventService = eventService;
    }

    @Scheduled(cron = "1* * * * *", zone = "Europe/Warsaw")
    public void eipaDataFetcher() {
        // fetch data every minute
        var latestTimestamp = datesService.getLatestTimestamp();
        var result = fetchEipaData();
        var newestData = eipaService.filterNewestData(result.getData(), latestTimestamp);
        // filter it with newest set of data
        // save it into db
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fetchDataAfterAppStart() {
        fetchEipaData();
    }

    private EipaRequestResult fetchEipaData() {
        var result = eipaService.fetchDynamicData();
        result.ifPresent(data -> {
            var timestamp = datesService.getHighestTimestamp(data.getData());
            datesService.insertNewTimestamp(timestamp);
        });

        return result.get();
    }
}
