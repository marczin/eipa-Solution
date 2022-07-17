package pl.marcinrosol.eipa.models.event;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class DynamicData {

    private String pointId;
    private Status status;
    private Timestamp originalTs;

    public DynamicData(String pointId, Status status, Timestamp originalTs) {
        this.pointId = pointId;
        this.status = status;
        this.originalTs = originalTs;
    }

    public DynamicData() {
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getOriginalTs() {
        return originalTs;
    }

    public void setOriginalTs(Timestamp originalTs) {
        this.originalTs = originalTs;
    }
}
