package org.pablochitolina.exercicio.integration.repository.itinerary;

import org.pablochitolina.exercicio.integration.model.ItineraryIntegrantionEntity;

import java.io.IOException;

public interface ItineraryIntegrationRepository {

    ItineraryIntegrantionEntity getBusItineraryByUnit(String unit) throws IOException;

}
