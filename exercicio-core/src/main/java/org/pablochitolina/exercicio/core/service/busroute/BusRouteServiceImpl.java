package org.pablochitolina.exercicio.core.service.busroute;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.port.busroute.BusRouteIntegrationPort;
import org.pablochitolina.exercicio.domain.port.busroute.BusRoutePersistencePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    private final BusRouteIntegrationPort busRouteIntegrationPort;
    private final BusRoutePersistencePort busRoutePersistencePort;

    public BusRouteServiceImpl(BusRouteIntegrationPort busRouteIntegrationPort, BusRoutePersistencePort busRoutePersistencePort) {
        this.busRouteIntegrationPort = busRouteIntegrationPort;
        this.busRoutePersistencePort = busRoutePersistencePort;
    }

    @Override
    public List<BusRouteIntegrationDto> getAllBusRoutesIntegration() {
        return busRouteIntegrationPort.getAllBusRoutes();
    }

    @Override
    public List<BusRouteIntegrationDto> getBusRoutesByName(String name) {
        var allRoutes = busRouteIntegrationPort.getAllBusRoutes();
        return allRoutes.stream().filter( r -> r.getNome().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public BusRoutePersistenceDto addBusRoute(BusRoutePersistenceDto busRouteDto) {
        return busRoutePersistencePort.addBusRoute(busRouteDto);
    }

    @Override
    @Transactional
    public void removeBusRoute(Long id) {
        busRoutePersistencePort.removeBusRoute(id);
    }

    @Override
    public List<BusRoutePersistenceDto> getAllBusRoutesPersistence() {
        return busRoutePersistencePort.getAllBusRoutes();
    }

    @Override
    public BusRoutePersistenceDto getBusRouteById(Long id) {
        return busRoutePersistencePort.getBusRouteById(id);
    }

}
