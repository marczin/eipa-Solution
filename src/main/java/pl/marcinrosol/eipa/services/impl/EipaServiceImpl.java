package pl.marcinrosol.eipa.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.marcinrosol.eipa.models.dao.DynamicDataDao;
import pl.marcinrosol.eipa.models.dao.EipaRequestResult;
import pl.marcinrosol.eipa.services.EipaService;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.marcinrosol.eipa.services.RequestsUrls.DYNAMIC_DATA_URL;

@Service
public class EipaServiceImpl implements EipaService {

    @Value("${api_key}")
    private String API_KEY;

    @Override
    public Optional<EipaRequestResult> fetchDynamicData() {
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForEntity(String.format(DYNAMIC_DATA_URL, API_KEY), EipaRequestResult.class);
        return Optional.ofNullable(result.getBody());
    }


    public List<DynamicDataDao> filterNewestData(Collection<DynamicDataDao> dataList, Timestamp timestamp) {
        return dataList.stream()
                .filter(data -> data.getStatus() != null)
                .filter(data -> data.getStatus().getTs() != null)
                .filter(data -> data.getStatus().getTs().after(timestamp)).collect(Collectors.toList());
    }

}
