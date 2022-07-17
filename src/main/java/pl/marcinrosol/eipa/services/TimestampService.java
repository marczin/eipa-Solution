package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.request.DynamicDataDao;

import java.sql.Timestamp;
import java.util.Collection;

public interface TimestampService {

    Timestamp getLatestTimestamp();

    void insertNewTimestamp(Timestamp timestamp);

    Timestamp getHighestCollectionTimestamp(Collection<DynamicDataDao> dataList);

}
