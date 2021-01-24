package org.pablochitolina.exercicio.rest.api.busroute;

import lombok.extern.slf4j.Slf4j;
import org.pablochitolina.exercicio.core.service.busroute.BusRouteService;
import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BusRouteControllerImpl implements BusRouteController {

    private final BusRouteService busRouteService;

    public BusRouteControllerImpl(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @Override
    public ResponseEntity<List<BusRouteIntegrationDto>> getAllBusRoutesIntegration() {
        return new ResponseEntity<>(busRouteService.getAllBusRoutesIntegration(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BusRouteIntegrationDto>> getBusRoutesByName(String name) {
        return new ResponseEntity<>(busRouteService.getBusRoutesByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BusRoutePersistenceDto> addBusRoute(BusRoutePersistenceDto busRoutePersistenceDto) {
        var dto = busRouteService.addBusRoute(busRoutePersistenceDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> removeBusRoute(Long id) {
        busRouteService.removeBusRoute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BusRoutePersistenceDto>> getAllBusRoutesPersistence(){
        var listDto = busRouteService.getAllBusRoutesPersistence();
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BusRoutePersistenceDto> getBusRouteById(Long id) {
        var dto = busRouteService.getBusRouteById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
