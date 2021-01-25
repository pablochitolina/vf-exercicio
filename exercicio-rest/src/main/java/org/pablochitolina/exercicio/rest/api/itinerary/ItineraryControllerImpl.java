package org.pablochitolina.exercicio.rest.api.itinerary;

import lombok.extern.slf4j.Slf4j;
import org.pablochitolina.exercicio.core.service.itinerary.ItineraryService;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/itineraries")
public class ItineraryControllerImpl implements ItineraryAPI {

    private final ItineraryService itineraryService;

    public ItineraryControllerImpl(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/integration/{unit}")
    public ResponseEntity<ItineraryIntegrationDto> getBusItineraryByUnit(String unit) {
        return new ResponseEntity<>(itineraryService.getBusItineraryByUnit(unit), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItineraryPersistenceDto> addItinerary(ItineraryPersistenceDto itineraryIntegrationDto) {
        var dto = itineraryService.addItinerary(itineraryIntegrationDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeItinerary(Long id) {
        itineraryService.removeItinerary(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItineraryPersistenceDto> getItineraryById(Long id) {
        var dto = itineraryService.getItineraryById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ItineraryPersistenceDto>> getAllItineraries() {
        var listDto = itineraryService.getAllItineraries();
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @GetMapping("/bus-route/{id}")
    public ResponseEntity<ItineraryPersistenceDto> getItineraryByBusRouteId(Long id) {
        var dto = itineraryService.getItineraryByBusRouteId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/list-by-coordinate-range")
    public ResponseEntity<List<ItineraryPersistenceDto>> getItinerariesByRange(Double lat, Double lng, Double range) {
        var listDto = itineraryService.getItinerariesByRange(lat, lng, range);
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

}
