package pl.marcinrosol.eipa.models.event;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class DynamicData {

    private String pointId;
    private Status status;
    private Timestamp originalTs;

}