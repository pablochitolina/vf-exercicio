package org.pablochitolina.exercicio.integration.adapter;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryIntegrationPort;
import org.pablochitolina.exercicio.integration.mapper.ItineraryIntegrationMapper;
import org.pablochitolina.exercicio.integration.repository.itinerary.ItineraryIntegrationRepository;
import org.springframework.stereotype.Service;

@Service
public class ItineraryIntegrationAdapter implements ItineraryIntegrationPort {

    private ItineraryIntegrationRepository itineraryIntegrationRepository;

    public ItineraryIntegrationAdapter(ItineraryIntegrationRepository itineraryIntegrationRepository) {
        this.itineraryIntegrationRepository = itineraryIntegrationRepository;
    }

    @Override
    public ItineraryIntegrationDto getBusItineraryByUnit(String unit) {

        return ItineraryIntegrationMapper.toDto(itineraryIntegrationRepository.getBusItineraryByUnit(unit));

    }
}
