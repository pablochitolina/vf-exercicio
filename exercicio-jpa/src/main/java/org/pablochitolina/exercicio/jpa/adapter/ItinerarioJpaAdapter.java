package org.pablochitolina.exercicio.jpa.adapter;

import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.domain.exception.ItineraryNotFoundException;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryPersistencePort;
import org.pablochitolina.exercicio.jpa.mapper.ItineraryJpaMapper;
import org.pablochitolina.exercicio.jpa.repository.ItineraryJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItinerarioJpaAdapter implements ItineraryPersistencePort {

    private ItineraryJpaRepository itineraryJpaRepository;

    public ItinerarioJpaAdapter(ItineraryJpaRepository itineraryJpaRepository) {
        this.itineraryJpaRepository = itineraryJpaRepository;
    }

    @Override
    public ItineraryPersistenceDto addItinerary(ItineraryPersistenceDto itineraryPersistenceDto) {
        final var busRotueEntity = ItineraryJpaMapper.toEntity(itineraryPersistenceDto);
        var entity = itineraryJpaRepository.save(busRotueEntity);

        return ItineraryJpaMapper.toDto(entity);
    }

    @Override
    public void removeItinerary(Long id) {
        itineraryJpaRepository.deleteById(id);
    }

    @Override
    public ItineraryPersistenceDto getItineraryById(Long id) {
        return ItineraryJpaMapper.toDto(itineraryJpaRepository.findById(id).orElseThrow(() -> new ItineraryNotFoundException(id)));
    }

    @Override
    public ItineraryPersistenceDto getItineraryByBusRouteId(Long id) {
        return ItineraryJpaMapper.toDto(itineraryJpaRepository.findItineraryByBusRouteId(id).orElseThrow(() -> new ItineraryNotFoundException(id)));
    }

    @Override
    public List<ItineraryPersistenceDto> getAllItineraries() {
        return itineraryJpaRepository.findAll()
                .stream()
                .map(ItineraryJpaMapper::toDto)
                .collect(Collectors.toList());
    }
}
