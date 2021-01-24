package org.pablochitolina.exercicio.rest.api.itinerary;

import lombok.extern.slf4j.Slf4j;
import org.pablochitolina.exercicio.core.service.itinerary.ItineraryService;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public ResponseEntity<ItineraryPersistenceDto> addItinerary(ItineraryPersistenceDto itineraryIntegrationDto) {
        var dto = itineraryService.addItinerary(itineraryIntegrationDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> removeItinerary(Long id) {
        itineraryService.removeItinerary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ItineraryPersistenceDto> getItineraryById(Long id) {
        var dto = itineraryService.getItineraryById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItineraryPersistenceDto>> getAllItineraries() {
        var listDto = itineraryService.getAllItineraries();
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ItineraryPersistenceDto> getItineraryByBusRouteId(Long id) {
        var dto = itineraryService.getItineraryByBusRouteId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
