package org.pablochitolina.exercicio.core.service.itinerary;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;

public interface ItineraryService {

    ItineraryIntegrationDto getBusItineraryByUnit(String unit);

}
