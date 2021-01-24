package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.jpa.model.ItineraryJpaEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ItineraryJpaMapper {

    public static ItineraryJpaEntity toEntity(ItineraryPersistenceDto dto) {

        return ItineraryJpaEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .id(dto.getId())
                .busRouteId(dto.getBusRouteId())
                .locations(dto.getLocations().stream().map(LocationJpaMapper::toEntity).collect(Collectors.toList()))
                .build();
    }

    public static ItineraryPersistenceDto toDto(ItineraryJpaEntity entity) {

        return ItineraryPersistenceDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .id(entity.getId())
                .busRouteId(entity.getBusRouteId())
                .locations(entity.getLocations().stream().map(LocationJpaMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}
