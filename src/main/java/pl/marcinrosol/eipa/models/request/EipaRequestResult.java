package pl.marcinrosol.eipa.models.request;

import java.util.List;

public class EipaRequestResult {

    private List<DynamicDataDao> data;

    public EipaRequestResult(List<DynamicDataDao> data) {
        this.data = data;
    }

    public EipaRequestResult() {
    }

    public List<DynamicDataDao> getData() {
        return data;
    }

    public void setData(List<DynamicDataDao> data) {
        this.data = data;
    }
}
