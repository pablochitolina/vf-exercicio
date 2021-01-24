package org.pablochitolina.exercicio.core.service.itinerary;

import org.pablochitolina.exercicio.core.service.util.DistanceCalculation;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryIntegrationPort;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryPersistencePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryIntegrationPort itineraryIntegrationPort;
    private final ItineraryPersistencePort itineraryPersistencePort;

    public ItineraryServiceImpl(ItineraryIntegrationPort itineraryIntegrationPort, ItineraryPersistencePort itineraryPersistencePort) {
        this.itineraryIntegrationPort = itineraryIntegrationPort;
        this.itineraryPersistencePort = itineraryPersistencePort;
    }

    @Override
    public ItineraryIntegrationDto getBusItineraryByUnit(String unit) {
        return itineraryIntegrationPort.getBusItineraryByUnit(unit);
    }

    @Override
    public ItineraryPersistenceDto addItinerary(ItineraryPersistenceDto itineraryPersistenceDto) {
        return itineraryPersistencePort.addItinerary(itineraryPersistenceDto);
    }

    @Override
    @Transactional
    public void removeItinerary(Long id) {
        itineraryPersistencePort.removeItinerary(id);
    }

    @Override
    public ItineraryPersistenceDto getItineraryById(Long id) {
        return itineraryPersistencePort.getItineraryById(id);
    }

    @Override
    public List<ItineraryPersistenceDto> getAllItineraries() {
        return itineraryPersistencePort.getAllItineraries();
    }

    @Override
    public List<ItineraryPersistenceDto> getItinerariesByRange(Double lat, Double lng, Double range) {
        var allItineraries = itineraryPersistencePort.getAllItineraries();

        return allItineraries.stream().filter(
                i -> i.getLocations().stream().filter(
                        l -> DistanceCalculation.distFrom(lat, lng , l.getLat(), l.getLng()) < range).count() > 0 )
                .collect(Collectors.toList());
    }

    @Override
    public ItineraryPersistenceDto getItineraryByBusRouteId(Long id) {
        return itineraryPersistencePort.getItineraryByBusRouteId(id);
    }

}
