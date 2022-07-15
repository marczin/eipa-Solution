package pl.marcinrosol.eipa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinrosol.eipa.services.EipaService;

@RestController
@RequestMapping("/api/eipa")
public class EipaController {

    private final EipaService eipaService;

    public EipaController(EipaService eipaService) {
        this.eipaService = eipaService;
    }

    @GetMapping
    public ResponseEntity getDynamicData() {
        var data = eipaService.fetchDynamicData();
        return new ResponseEntity(HttpStatus.OK);
    }
}
