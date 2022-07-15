package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.dao.DynamicDataDao;
import pl.marcinrosol.eipa.models.dao.EipaRequestResult;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EipaService {

    Optional<EipaRequestResult> fetchDynamicData();

    List<DynamicDataDao> filterNewestData(Collection<DynamicDataDao> dataList, Timestamp timestamp);
}
