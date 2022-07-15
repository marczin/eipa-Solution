package pl.marcinrosol.eipa.models.dao;

import java.util.List;

public class DynamicDataDao {

    private Long point_id;
    private String code;
    private List<PriceDao> prices;
    private StatusDao status;

    public DynamicDataDao(Long point_id, String code, List<PriceDao> prices, StatusDao status) {
        this.point_id = point_id;
        this.code = code;
        this.prices = prices;
        this.status = status;
    }

    public DynamicDataDao() {
    }

    public Long getPoint_id() {
        return point_id;
    }

    public void setPoint_id(Long point_id) {
        this.point_id = point_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PriceDao> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceDao> prices) {
        this.prices = prices;
    }

    public StatusDao getStatus() {
        return status;
    }

    public void setStatus(StatusDao status) {
        this.status = status;
    }
}
