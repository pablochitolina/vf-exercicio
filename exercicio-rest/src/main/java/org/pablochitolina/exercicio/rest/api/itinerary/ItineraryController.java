package org.pablochitolina.exercicio.rest.api.itinerary;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/itineraries")
public interface ItineraryController {

    @GetMapping("/integration/{unit}")
    ResponseEntity<ItineraryIntegrationDto> getBusItineraryByUnit(@PathVariable String unit);

    @PostMapping
    ResponseEntity<ItineraryPersistenceDto> addItinerary(@RequestBody ItineraryPersistenceDto itineraryIntegrationDto);

    @DeleteMapping("/{id}")
    ResponseEntity<String> removeItinerary(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<ItineraryPersistenceDto> getItineraryById(@PathVariable Long id);

    @GetMapping("/list")
    ResponseEntity<List<ItineraryPersistenceDto>> getAllItineraries();

    @GetMapping("/bus-route/{id}")
    ResponseEntity<ItineraryPersistenceDto> getItineraryByBusRouteId(@PathVariable Long id);

}
