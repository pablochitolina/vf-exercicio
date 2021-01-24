package org.pablochitolina.exercicio.integration.adapter;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.port.busroute.BusRouteIntegrationPort;

import org.pablochitolina.exercicio.integration.mapper.BusRouteIntegrationMapper;
import org.pablochitolina.exercicio.integration.repository.busroute.BusRouteIntegrationRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusRouteIntegrationAdapter implements BusRouteIntegrationPort {

    private BusRouteIntegrationRepository busRouteIntegrationRepository;

    public BusRouteIntegrationAdapter(BusRouteIntegrationRepository busRouteIntegrationRepository) {
        this.busRouteIntegrationRepository = busRouteIntegrationRepository;
    }

    @Override
    public List<BusRouteIntegrationDto> getAllBusRoutes() {

        try {
            return busRouteIntegrationRepository.getAllBusRoutes()
                    .stream()
                    .map(BusRouteIntegrationMapper::toDto)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
