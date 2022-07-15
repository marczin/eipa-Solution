package pl.marcinrosol.eipa.models.dao;

import java.sql.Timestamp;
import java.util.Date;

public class StatusDao {
    // status":{"availability":1,"status":1,"ts":"2022-07-14T23:30:38+02:00"
    private Long availability;
    private Long status;
    private Timestamp ts;

    public StatusDao() {
    }

    public StatusDao(Long availability, Long status, Timestamp ts) {
        this.availability = availability;
        this.status = status;
        this.ts = ts;
    }

    public Long getAvailability() {
        return availability;
    }

    public void setAvailability(Long availability) {
        this.availability = availability;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
