package org.pablochitolina.exercicio.core.service;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.port.BusIntegrationPort;
import org.pablochitolina.exercicio.domain.port.BusPersistencePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    private final BusIntegrationPort busIntegrationPort;
    private final BusPersistencePort busPersistencePort;

    public BusRouteServiceImpl(BusIntegrationPort busIntegrationPort, BusPersistencePort busPersistencePort) {
        this.busIntegrationPort = busIntegrationPort;
        this.busPersistencePort = busPersistencePort;
    }

    @Override
    public List<BusRouteIntegrationDto> getAllBusRoutesIntegration() {
        return busIntegrationPort.getAllBusRoutes();
    }

    @Override
    public List<BusRouteIntegrationDto> getBusRoutesByName(String name) {
        var allRoutes = busIntegrationPort.getAllBusRoutes();
        return allRoutes.stream().filter( r -> r.getNome().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public ItineraryIntegrationDto getBusItineraryByUnit(String unit) {
        return busIntegrationPort.getBusItineraryByUnit(unit);
    }

    @Override
    public BusRoutePersistenceDto addBusRoute(BusRoutePersistenceDto busRouteDto) {
        return busPersistencePort.addBusRoute(busRouteDto);
    }

    @Override
    @Transactional
    public void removeBusRoute(Long id) {
        busPersistencePort.removeBusRoute(id);
    }

    @Override
    public List<BusRoutePersistenceDto> getAllBusRoutesPersistence() {
        return busPersistencePort.getAllBusRoutes();
    }

    @Override
    public BusRoutePersistenceDto getBusRouteById(Long id) {
        return busPersistencePort.getBusRouteById(id);
    }

}
