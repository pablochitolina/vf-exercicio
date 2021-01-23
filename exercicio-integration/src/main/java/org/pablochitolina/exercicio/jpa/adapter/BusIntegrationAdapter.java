package org.pablochitolina.exercicio.jpa.adapter;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.port.BusIntegrationPort;
import org.pablochitolina.exercicio.jpa.mapper.BusRouteMapper;
import org.pablochitolina.exercicio.jpa.mapper.ItineraryMapper;
import org.pablochitolina.exercicio.jpa.repository.BusIntegrationRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusIntegrationAdapter implements BusIntegrationPort {

    private BusIntegrationRepository busIntegrationRepository;

    public BusIntegrationAdapter(BusIntegrationRepository busIntegrationRepository) {
        this.busIntegrationRepository = busIntegrationRepository;
    }


    @Override
    public List<BusRouteIntegrationDto> getAllBusRoutes() {

        try {
            return busIntegrationRepository.getAllBusRoutes()
                    .stream()
                    .map(BusRouteMapper::toDto)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ItineraryIntegrationDto getBusItineraryByUnit(String unit) {

        try {
            return ItineraryMapper.toDto(busIntegrationRepository.getBusItineraryByUnit(unit));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
