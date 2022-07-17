package pl.marcinrosol.eipa.models.response;

import pl.marcinrosol.eipa.models.event.EipaEvent;

import java.util.List;

public class EventDataResponse {

    private List<EipaEvent> events;

    public EventDataResponse(List<EipaEvent> events) {
        this.events = events;
    }

    public EventDataResponse() {
    }

    public List<EipaEvent> getEvents() {
        return events;
    }

    public void setEvents(List<EipaEvent> events) {
        this.events = events;
    }
}
