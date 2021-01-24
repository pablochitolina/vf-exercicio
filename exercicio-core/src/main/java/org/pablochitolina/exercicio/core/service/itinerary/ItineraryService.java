package org.pablochitolina.exercicio.core.service.itinerary;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;

import java.util.List;

public interface ItineraryService {

    ItineraryIntegrationDto getBusItineraryByUnit(String unit);

    ItineraryPersistenceDto addItinerary(ItineraryPersistenceDto busRouteDto);

    void removeItinerary(Long id);

    ItineraryPersistenceDto getItineraryById(Long id);

    List<ItineraryPersistenceDto> getAllItineraries();

    List<ItineraryPersistenceDto> getItinerariesByRange(Double lat, Double lng, Double range);

    ItineraryPersistenceDto getItineraryByBusRouteId(Long id);

}
