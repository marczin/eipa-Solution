package pl.marcinrosol.eipa.models.event;

import java.sql.Timestamp;

public abstract class Event {

    private String id;
    private Timestamp ts;
    private EventType type;

    protected Event() {
    }

    protected Event(String id, Timestamp ts, EventType eventType) {
        this.id = id;
        this.ts = ts;
        this.type = eventType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
