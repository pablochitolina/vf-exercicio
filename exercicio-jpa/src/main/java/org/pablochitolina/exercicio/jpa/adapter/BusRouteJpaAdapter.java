package org.pablochitolina.exercicio.jpa.adapter;

import lombok.SneakyThrows;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.exception.BusRouteNotFoundException;
import org.pablochitolina.exercicio.domain.port.busroute.BusRoutePersistencePort;
import org.pablochitolina.exercicio.jpa.mapper.BusRouteJpaMapper;
import org.pablochitolina.exercicio.jpa.repository.BusRouteJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;
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

    /*@Override
    public void updateLyrics(LyricsDto lyricsDto) {
        final LyricsEntity byParticipatingArtist = lyricsRepository.findByParticipatingArtist(lyricsDto.getParticipatingArtist());
        if (Objects.nonNull(byParticipatingArtist)) {
            byParticipatingArtist.setLyrics(lyricsDto.getLyrics());
            lyricsRepository.save(byParticipatingArtist);
        } else {
            final LyricsEntity byLyrics = lyricsRepository.findByLyrics(lyricsDto.getLyrics());
            if (Objects.nonNull(byLyrics)) {
                byLyrics.setParticipatingArtist(lyricsDto.getParticipatingArtist());
                lyricsRepository.save(byLyrics);
            }
        }
    }*/

    @Override
    public List<BusRoutePersistenceDto> getAllBusRoutes() {
        return busRouteJpaRepository.findAll()
                .stream()
                .map(BusRouteJpaMapper::toDto)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public BusRoutePersistenceDto getBusRouteById(Long id) {
        return BusRouteJpaMapper.toDto(busRouteJpaRepository.findById(id).orElseThrow((Supplier<Throwable>) () -> new BusRouteNotFoundException(id)));
    }
}
