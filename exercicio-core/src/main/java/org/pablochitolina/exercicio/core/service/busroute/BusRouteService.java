package org.pablochitolina.exercicio.core.service.busroute;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;

import java.util.List;

public interface BusRouteService {

    List<BusRouteIntegrationDto> getAllBusRoutesIntegration();

    List<BusRouteIntegrationDto> getBusRoutesByName(String name);

    BusRoutePersistenceDto addBusRoute(BusRoutePersistenceDto busRouteDto);

    void removeBusRoute(Long id);

    List<BusRoutePersistenceDto> getAllBusRoutesPersistence();

    BusRoutePersistenceDto getBusRouteById(Long id);

}
