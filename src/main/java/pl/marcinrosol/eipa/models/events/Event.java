package pl.marcinrosol.eipa.models.events;

public abstract class Event {

    protected String id;
    protected String ts;
    protected EventType type;

    public Event() {
    }

    public Event(String id, String ts, EventType eventType) {
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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
