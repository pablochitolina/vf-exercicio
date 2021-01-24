package org.pablochitolina.exercicio.domain.port.itinerary;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;

public interface ItineraryIntegrationPort {

    ItineraryIntegrationDto getBusItineraryByUnit(String unit);

}
