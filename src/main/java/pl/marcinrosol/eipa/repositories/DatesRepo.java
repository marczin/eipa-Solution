package pl.marcinrosol.eipa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.marcinrosol.eipa.models.repos.LatestDate;

import java.sql.Timestamp;

@Repository
public interface DatesRepo extends JpaRepository<LatestDate, Long> {

    @Query("SELECT ld.time FROM  LatestDate ld ORDER BY ld.time DESC")
    Timestamp getLatestTimestamp();


}
