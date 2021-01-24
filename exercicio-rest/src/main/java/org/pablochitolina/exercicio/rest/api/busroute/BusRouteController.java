package org.pablochitolina.exercicio.rest.api.busroute;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/routes")
public interface BusRouteController {

    @GetMapping("/integration-list")
    ResponseEntity<List<BusRouteIntegrationDto>> getAllBusRoutesIntegration();

    @GetMapping("/integration/{name}")
    ResponseEntity<List<BusRouteIntegrationDto>> getBusRoutesByName(@PathVariable String name);

    @PostMapping
    ResponseEntity<BusRoutePersistenceDto> addBusRoute(@RequestBody BusRoutePersistenceDto busRoutePersistenceDtoS);

    @DeleteMapping("/{id}")
    ResponseEntity<String> removeBusRoute(@PathVariable Long id);

    @GetMapping("/list")
    ResponseEntity<List<BusRoutePersistenceDto>> getAllBusRoutesPersistence();

    @GetMapping("/{id}")
    ResponseEntity<BusRoutePersistenceDto> getBusRouteById(@PathVariable Long id);

}
