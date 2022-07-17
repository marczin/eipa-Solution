package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.models.request.EipaRequestResult;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public interface EipaService {

    EipaRequestResult fetchDynamicData();

    List<DynamicDataDao> filterNewestData(Collection<DynamicDataDao> dataList, Timestamp timestamp);

}
