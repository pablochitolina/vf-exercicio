package org.pablochitolina.exercicio.integration.repository.busroute;

import org.pablochitolina.exercicio.integration.model.BusRouteIntegrantionEntity;

import java.io.IOException;
import java.util.List;

public interface BusRouteIntegrationRepository {

    List<BusRouteIntegrantionEntity> getAllBusRoutes() throws IOException;

}
