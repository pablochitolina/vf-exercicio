package org.pablochitolina.exercicio.domain.port.itinerary;


import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;

import java.util.List;

public interface ItineraryPersistencePort {

    ItineraryPersistenceDto addItinerary(ItineraryPersistenceDto itineraryPersistenceDto);

    void removeItinerary(Long id);

    ItineraryPersistenceDto getItineraryById(Long id);

    ItineraryPersistenceDto getItineraryByBusRouteId(Long busRouteId);

    List<ItineraryPersistenceDto> getAllItineraries();

}
