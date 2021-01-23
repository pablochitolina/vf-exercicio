package org.pablochitolina.exercicio.jpa.repository;

import org.pablochitolina.exercicio.jpa.model.BusRouteEntity;
import org.pablochitolina.exercicio.jpa.model.ItineraryEntity;

import java.io.IOException;
import java.util.List;

public interface BusIntegrationRepository {

    List<BusRouteEntity> getAllBusRoutes() throws IOException;
    ItineraryEntity getBusItineraryByUnit(String unit) throws IOException;

}
