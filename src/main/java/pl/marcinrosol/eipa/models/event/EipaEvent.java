package pl.marcinrosol.eipa.models.event;

import java.sql.Timestamp;

public class EipaEvent extends Event {

    private DynamicData data;

    public EipaEvent(String id, Timestamp ts, EventType eventType, DynamicData data) {
        super(id, ts, eventType);
        this.data = data;
    }

    public EipaEvent() {
    }

    public DynamicData getData() {
        return data;
    }

    public void setData(DynamicData data) {
        this.data = data;
    }
}
