package pl.marcinrosol.eipa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import pl.marcinrosol.eipa.repositories.DatesRepo;
import pl.marcinrosol.eipa.services.impl.TimestampServiceImpl;

import java.util.Optional;

@SpringBootTest
public class TimestampServiceTest extends TestData {

    @Mock
    DatesRepo datesRepo;

    @InjectMocks
    TimestampServiceImpl timestampService;

    @Test
    void testGettingHighestTimestamp() {
        var result = timestampService.getHighestCollectionTimestamp(prepareDataList());
        Assertions.assertEquals(TIMESTAMP_1, result.get());
    }

    @Test
    void testGettingHighestTimestampWhenOneStatusIsNull() {
        var result = timestampService.getHighestCollectionTimestamp(prepareOneStatusDataList());
        Assertions.assertEquals(TIMESTAMP_1, result.get());
    }

    @Test
    void testGettingHighestTimestampWhenStatusIsNull() {
        var result = timestampService.getHighestCollectionTimestamp(prepareNullDataList());
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void getLatestTimestamp() {
        Mockito.when(datesRepo.getLatestTimestamp()).thenReturn(TIMESTAMP_1);
        var result = timestampService.getLatestTimestamp();
        Assertions.assertEquals(TIMESTAMP_1, result);
    }

}
