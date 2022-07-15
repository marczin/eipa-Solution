package pl.marcinrosol.eipa.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.marcinrosol.eipa.models.dao.EipaRequestResult;

import java.util.Optional;

import static pl.marcinrosol.eipa.services.RequestsUrls.DYNAMIC_DATA_URL;

@Service
public class EipaSerivceImpl implements EipaService {

    @Override
    public Optional<EipaRequestResult> fetchDynamicData() {
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForEntity(DYNAMIC_DATA_URL, EipaRequestResult.class);
        return Optional.ofNullable(result.getBody());
    }
}
