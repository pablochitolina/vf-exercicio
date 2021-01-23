package org.pablochitolina.exercicio.jpa.adapter;

import lombok.SneakyThrows;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.exception.BusRouteNotFoundException;
import org.pablochitolina.exercicio.domain.port.BusPersistencePort;
import org.pablochitolina.exercicio.jpa.mapper.BusRouteMapper;
import org.pablochitolina.exercicio.jpa.repository.BusJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class BusJpaAdapter implements BusPersistencePort {

    private BusJpaRepository busJpaRepository;

    public BusJpaAdapter(BusJpaRepository busJpaRepository) {
        this.busJpaRepository = busJpaRepository;
    }

    @Override
    public BusRoutePersistenceDto addBusRoute(BusRoutePersistenceDto busRouteDto) {
        final var busRotueEntity = BusRouteMapper.toEntity(busRouteDto);
        var entity = busJpaRepository.save(busRotueEntity);

        return BusRouteMapper.toDto(entity);
    }

    @Override
    public void removeBusRoute(Long id) {
        busJpaRepository.deleteById(id);
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
        return busJpaRepository.findAll()
                .stream()
                .map(BusRouteMapper::toDto)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public BusRoutePersistenceDto getBusRouteById(Long id) {
        return BusRouteMapper.toDto(busJpaRepository.findById(id).orElseThrow((Supplier<Throwable>) () -> new BusRouteNotFoundException(id)));
    }
}
