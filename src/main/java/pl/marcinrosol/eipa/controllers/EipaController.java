package pl.marcinrosol.eipa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinrosol.eipa.models.response.EventDataResponse;
import pl.marcinrosol.eipa.services.EipaService;

@RestController
@RequestMapping("/api/eipa")
public class EipaController {

    Logger logger = LoggerFactory.getLogger(EipaController.class);

    private final EipaService eipaService;

    public EipaController(EipaService eipaService) {
        this.eipaService = eipaService;
    }

    @PostMapping( "/event/consumer")
    public ResponseEntity consumer(@RequestBody EventDataResponse body) {
        logger.info("Consuming events omomomomom");
        return ResponseEntity.ok().build();
    }
}
