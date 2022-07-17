package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.request.DynamicDataDao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Optional;

public interface TimestampService {

    Timestamp getLatestTimestamp();

    void insertNewTimestamp(Timestamp timestamp);

    Optional<Timestamp> getHighestCollectionTimestamp(Collection<DynamicDataDao> dataList);

}
