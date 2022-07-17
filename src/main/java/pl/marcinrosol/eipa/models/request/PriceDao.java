package pl.marcinrosol.eipa.models.request;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PriceDao {

    private BigDecimal price;
    private String unit;
    private Timestamp ts;

    public PriceDao(BigDecimal price, String unit, Timestamp ts) {
        this.price = price;
        this.unit = unit;
        this.ts = ts;
    }

    public PriceDao() {;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

}
