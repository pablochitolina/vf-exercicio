package org.pablochitolina.exercicio.core.service.itinerary;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryIntegrationPort;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryIntegrationPort itineraryIntegrationPort;
    //private final ItineraryPersistencePort itineraryPersistencePort;

    public ItineraryServiceImpl(ItineraryIntegrationPort itineraryIntegrationPort) {
        this.itineraryIntegrationPort = itineraryIntegrationPort;
        //this.itineraryPersistencePort = itineraryPersistencePort;
    }

    @Override
    public ItineraryIntegrationDto getBusItineraryByUnit(String unit) {
        return itineraryIntegrationPort.getBusItineraryByUnit(unit);
    }


}
