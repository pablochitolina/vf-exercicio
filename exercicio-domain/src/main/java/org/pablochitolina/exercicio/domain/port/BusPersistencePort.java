package org.pablochitolina.exercicio.domain.port;


import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;

import java.util.List;

public interface BusPersistencePort {

    BusRoutePersistenceDto addBusRoute(BusRoutePersistenceDto busRouteDto);

    void removeBusRoute(Long id);

    List<BusRoutePersistenceDto> getAllBusRoutes();

    BusRoutePersistenceDto getBusRouteById(Long id);
}
