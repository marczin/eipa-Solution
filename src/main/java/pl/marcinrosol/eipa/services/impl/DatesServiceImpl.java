package pl.marcinrosol.eipa.services.impl;

import org.springframework.stereotype.Service;
import pl.marcinrosol.eipa.models.dao.DynamicDataDao;
import pl.marcinrosol.eipa.repositories.DatesRepo;
import pl.marcinrosol.eipa.services.DatesService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DatesServiceImpl implements DatesService {

    private final DatesRepo datesRepo;

    private static String INSERT_TIMESTAMP = "insert into latest_dates (time) values (?);";

    @PersistenceContext
    private EntityManager entityManager;

    public DatesServiceImpl(DatesRepo datesRepo) {
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
    public Timestamp getHighestTimestamp(Collection<DynamicDataDao> dataList) {
        Comparator<DynamicDataDao> timestampComparator = (v1, v2) -> v1.getStatus().getTs().before(v2.getStatus().getTs()) ? 1 : -1;
        var sortedData = dataList.stream()
                .filter(data -> data.getStatus() != null)
                .filter(data -> data.getStatus().getTs() != null)
                .sorted(timestampComparator)
                .collect(Collectors.toList());
        return sortedData.stream().findFirst().get().getStatus().getTs();
    }
}
