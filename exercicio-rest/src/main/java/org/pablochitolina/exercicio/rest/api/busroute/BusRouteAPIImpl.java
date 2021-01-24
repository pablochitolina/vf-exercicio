package org.pablochitolina.exercicio.rest.api.busroute;

import org.pablochitolina.exercicio.core.service.busroute.BusRouteService;
import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/routes")
public class BusRouteAPIImpl implements BusRouteAPI {

    private final BusRouteService busRouteService;

    public BusRouteAPIImpl(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @GetMapping("/integration-list")
    public ResponseEntity<List<BusRouteIntegrationDto>> getAllBusRoutesIntegration() {
        return new ResponseEntity<>(busRouteService.getAllBusRoutesIntegration(), HttpStatus.OK);
    }

    @GetMapping("/integration/{name}")
    public ResponseEntity<List<BusRouteIntegrationDto>> getBusRoutesByName(String name) {
        return new ResponseEntity<>(busRouteService.getBusRoutesByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BusRoutePersistenceDto> addBusRoute(BusRoutePersistenceDto busRoutePersistenceDto) {
        var dto = busRouteService.addBusRoute(busRoutePersistenceDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeBusRoute(Long id) {
        busRouteService.removeBusRoute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BusRoutePersistenceDto>> getAllBusRoutesPersistence(){
        var listDto = busRouteService.getAllBusRoutesPersistence();
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusRoutePersistenceDto> getBusRouteById(Long id) {
        var dto = busRouteService.getBusRouteById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
