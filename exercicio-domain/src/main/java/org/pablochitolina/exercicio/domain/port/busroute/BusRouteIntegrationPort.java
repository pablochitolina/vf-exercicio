package org.pablochitolina.exercicio.domain.port.busroute;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;

import java.util.List;

public interface BusRouteIntegrationPort {

    List<BusRouteIntegrationDto> getAllBusRoutes();

}
