package pl.marcinrosol.eipa.models.repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "latest_dates")
public class LatestDate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Timestamp time;

    public LatestDate() {
    }

    public LatestDate(Long id, Timestamp time) {
        this.id = id;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
