package pl.marcinrosol.eipa.models.repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class EipaData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String data;
    private Date saveAtDate;
    private Date consumedAtDate;

    public EipaData() {
    }

    public EipaData(Long id, String data, Date saveAtDate, Date consumedAtDate) {
        this.id = id;
        this.data = data;
        this.saveAtDate = saveAtDate;
        this.consumedAtDate = consumedAtDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getSaveAtDate() {
        return saveAtDate;
    }

    public void setSaveAtDate(Date saveAtDate) {
        this.saveAtDate = saveAtDate;
    }

    public Date getConsumedAtDate() {
        return consumedAtDate;
    }

    public void setConsumedAtDate(Date consumedAtDate) {
        this.consumedAtDate = consumedAtDate;
    }
}
