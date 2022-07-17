package pl.marcinrosol.eipa.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.marcinrosol.eipa.models.request.DynamicDataDao;
import pl.marcinrosol.eipa.models.request.EipaRequestResult;
import pl.marcinrosol.eipa.services.EipaService;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static pl.marcinrosol.eipa.services.RequestsUrls.DYNAMIC_DATA_URL;

@Service
public class EipaServiceImpl implements EipaService {

    @Value("${api_key}")
    private String API_KEY;

    @Override
    public EipaRequestResult fetchDynamicData() {
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForEntity(String.format(DYNAMIC_DATA_URL, API_KEY), EipaRequestResult.class);
        return result.getBody();
    }

    @Override
    public List<DynamicDataDao> filterNewestData(Collection<DynamicDataDao> dataList, Timestamp timestamp) {
        var result = filterNonNulls(dataList);
        if (timestamp != null) {
            return result.stream().filter(data -> data.getStatus().getTs().after(timestamp)).collect(Collectors.toList());
        }
        return result;
    }

    private List<DynamicDataDao> filterNonNulls(Collection<DynamicDataDao> dynamicData) {
        return dynamicData.stream()
                .filter(data -> data.getStatus() != null)
                .filter(data -> data.getStatus().getTs() != null).collect(Collectors.toList());
    }

}