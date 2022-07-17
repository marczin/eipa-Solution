package pl.marcinrosol.eipa.services.impl;

import org.springframework.stereotype.Service;
import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.repositories.DatesRepo;
import pl.marcinrosol.eipa.services.TimestampService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class TimestampServiceImpl implements TimestampService {

    private final DatesRepo datesRepo;

    private static String INSERT_TIMESTAMP = "INSERT INTO latest_dates (time) VALUES (?);";

    @PersistenceContext
    private EntityManager entityManager;

    public TimestampServiceImpl(DatesRepo datesRepo) {
        this.datesRepo = datesRepo;
    }

    @Override
    public Timestamp getLatestTimestamp() {
        return datesRepo.getLatestTimestamp();
    }

    @Override
    @Transactional
    public void insertNewTimestamp(Timestamp timestamp) {
        entityManager.createNativeQuery(INSERT_TIMESTAMP)
                .setParameter(1, timestamp)
                .executeUpdate();
    }

    @Override
    public Timestamp getHighestCollectionTimestamp(Collection<DynamicDataDao> dataList) {
        Comparator<DynamicDataDao> timestampComparator = (v1, v2) -> v1.getStatus().getTs().before(v2.getStatus().getTs()) ? 1 : -1;
        var sortedData = dataList.stream()
                .filter(data -> data.getStatus() != null)
                .filter(data -> data.getStatus().getTs() != null)
                .sorted(timestampComparator)
                .collect(Collectors.toList());
        return sortedData.stream().findFirst().get().getStatus().getTs();
    }
}
