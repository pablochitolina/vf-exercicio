package org.pablochitolina.exercicio.rest.api.itinerary;

import lombok.extern.slf4j.Slf4j;
import org.pablochitolina.exercicio.core.service.itinerary.ItineraryService;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ItineraryControllerImpl implements ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryControllerImpl(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @Override
    public ResponseEntity<ItineraryIntegrationDto> getBusItineraryByUnit(String unit) {
        return new ResponseEntity<>(itineraryService.getBusItineraryByUnit(unit), HttpStatus.OK);
    }

}
