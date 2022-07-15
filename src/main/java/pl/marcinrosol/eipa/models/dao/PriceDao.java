package pl.marcinrosol.eipa.models.dao;

import java.math.BigDecimal;

public class PriceDao {

    private BigDecimal price;
    private String unit;
    private String ts;

    public PriceDao(BigDecimal price, String unit, String ts) {
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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    // {"price":"1.21","unit":"kWh","ts":"2022-07-15T12:00:48+02:00"}

}
