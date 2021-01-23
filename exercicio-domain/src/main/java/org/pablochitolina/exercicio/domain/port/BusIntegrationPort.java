package org.pablochitolina.exercicio.domain.port;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;

import java.util.List;

public interface BusIntegrationPort {

    List<BusRouteIntegrationDto> getAllBusRoutes();
    ItineraryIntegrationDto getBusItineraryByUnit(String unit);

}
