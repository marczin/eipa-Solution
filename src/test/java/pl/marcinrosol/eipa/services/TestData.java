package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.models.request.StatusDao;

import java.sql.Timestamp;
import java.util.List;

public abstract class TestData {

    protected static final String UUID_1 = "fb79cde3-d6aa-4a55-9786-ece883f8201a";
    protected static final String UUID_2 = "fb79cde3-d6aa-4a55-9786-ece883f8201b";
    protected static final String UUID_3 = "fb79cde3-d6aa-4a55-9786-ece883f8201c";

    protected static final Timestamp TIMESTAMP_1 = Timestamp.valueOf("2022-07-15 12:00:48");
    protected static final Timestamp TIMESTAMP_2 = Timestamp.valueOf("2022-07-15 11:00:48");
    protected static final Timestamp TIMESTAMP_3 = Timestamp.valueOf("2022-07-15 10:00:48");

    public TestData() {
    }

    protected List<DynamicDataDao> prepareDataList() {
        return List.of(
                buildDynamicDataDao(1L, UUID_1, buildStatus(1L, 1L, TIMESTAMP_1)),
                buildDynamicDataDao(1L, UUID_2, buildStatus(1L, 0L, TIMESTAMP_2)),
                buildDynamicDataDao(1L, UUID_3, buildStatus(0L, 0L, TIMESTAMP_3)));
    }

    protected List<DynamicDataDao> prepareOneStatusDataList() {
        return List.of(
                buildDynamicDataDao(1L, UUID_1, buildStatus(1L, 1L, TIMESTAMP_1)),
                buildDynamicDataDao(1L, UUID_2, null));
    }

    protected List<DynamicDataDao> prepareNullDataList() {
        return List.of(
                buildDynamicDataDao(1L, UUID_1, null),
                buildDynamicDataDao(1L, UUID_2, null));
    }

    protected DynamicDataDao buildDynamicDataDao(Long pointId, String code, StatusDao status) {
        DynamicDataDao data = new DynamicDataDao();
        data.setCode(code);
        data.setPoint_id(pointId);
        data.setPrices(List.of());
        data.setStatus(status);
        return data;
    }

    protected StatusDao buildStatus(Long available, Long status, Timestamp timestamp) {
        StatusDao statusDao = new StatusDao();
        statusDao.setStatus(status);
        statusDao.setAvailability(available);
        statusDao.setTs(timestamp);
        return statusDao;
    }
}
