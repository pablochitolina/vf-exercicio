package org.pablochitolina.exercicio.rest;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/bus")
public interface BusRouteController {

    @GetMapping("/integration-routes-list")
    ResponseEntity<List<BusRouteIntegrationDto>> getAllBusRoutesIntegration();

    @GetMapping("/integration-routes/{name}")
    ResponseEntity<List<BusRouteIntegrationDto>> getBusRoutesByName(@PathVariable String name);

    @GetMapping("/integration-itinerary/{unit}")
    ResponseEntity<ItineraryIntegrationDto> getBusItineraryByUnit(@PathVariable String unit);

    @PostMapping("/routes")
    ResponseEntity<BusRoutePersistenceDto> addBusRoute(@RequestBody BusRoutePersistenceDto busRoutePersistenceDtoS);

    @DeleteMapping("/routes/{id}")
    ResponseEntity<String> removeBusRoute(@PathVariable Long id);

    @GetMapping("/routes-list")
    ResponseEntity<List<BusRoutePersistenceDto>> getAllBusRoutesPersistence();

    @GetMapping("/routes/{id}")
    ResponseEntity<BusRoutePersistenceDto> getBusRouteById(@PathVariable Long id);

}
