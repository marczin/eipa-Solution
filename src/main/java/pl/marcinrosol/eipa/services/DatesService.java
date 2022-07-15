package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.dao.DynamicDataDao;

import java.sql.Timestamp;
import java.util.Collection;

public interface DatesService {

    Timestamp getLatestTimestamp();

    void insertNewTimestamp(Timestamp timestamp);

    Timestamp getHighestTimestamp(Collection<DynamicDataDao> dataList);

}
