package pl.marcinrosol.eipa.models.response;

public class DynamicData {
    private String pointId;
    private Status status;
    private String originalTs;

    public DynamicData() {
    }

    public DynamicData(String pointId, Status status, String originalTs) {
        this.pointId = pointId;
        this.status = status;
        this.originalTs = originalTs;
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

    public String getOriginalTs() {
        return originalTs;
    }

    public void setOriginalTs(String originalTs) {
        this.originalTs = originalTs;
    }
}
