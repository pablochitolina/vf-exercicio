package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.jpa.model.ItineraryEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ItineraryMapper {

    public static ItineraryEntity toEntity(ItineraryPersistenceDto dto) {

        return ItineraryEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .id(dto.getId())
                .locations(dto.getLocations().stream().map(LocationMapper::toEntity).collect(Collectors.toList()))
                .build();
    }

    public static ItineraryPersistenceDto toDto(ItineraryEntity entity) {

        return ItineraryPersistenceDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .id(entity.getId())
                .locations(entity.getLocations().stream().map(LocationMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}
