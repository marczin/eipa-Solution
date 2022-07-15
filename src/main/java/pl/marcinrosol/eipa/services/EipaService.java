package pl.marcinrosol.eipa.services;

import pl.marcinrosol.eipa.models.dao.EipaRequestResult;

import java.util.Optional;

public interface EipaService {

    Optional<EipaRequestResult> fetchDynamicData();
}
