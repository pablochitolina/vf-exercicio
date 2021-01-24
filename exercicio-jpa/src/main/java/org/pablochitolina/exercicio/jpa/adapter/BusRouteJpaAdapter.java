package org.pablochitolina.exercicio.jpa.adapter;

import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.exception.BusRouteNotFoundException;
import org.pablochitolina.exercicio.domain.port.busroute.BusRoutePersistencePort;
import org.pablochitolina.exercicio.jpa.mapper.BusRouteJpaMapper;
import org.pablochitolina.exercicio.jpa.repository.BusRouteJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusRouteJpaAdapter implements BusRoutePersistencePort {

    private BusRouteJpaRepository busRouteJpaRepository;

    public BusRouteJpaAdapter(BusRouteJpaRepository busRouteJpaRepository) {
        this.busRouteJpaRepository = busRouteJpaRepository;
    }

    @Override
    public BusRoutePersistenceDto addBusRoute(BusRoutePersistenceDto busRouteDto) {
        final var busRotueEntity = BusRouteJpaMapper.toEntity(busRouteDto);
        var entity = busRouteJpaRepository.save(busRotueEntity);

        return BusRouteJpaMapper.toDto(entity);
    }

    @Override
    public void removeBusRoute(Long id) {
        busRouteJpaRepository.deleteById(id);
    }

     @Override
    public List<BusRoutePersistenceDto> getAllBusRoutes() {
        return busRouteJpaRepository.findAll()
                .stream()
                .map(BusRouteJpaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BusRoutePersistenceDto getBusRouteById(Long id) {
        return BusRouteJpaMapper.toDto(busRouteJpaRepository.findById(id).orElseThrow(() -> new BusRouteNotFoundException(id)));
    }
}
