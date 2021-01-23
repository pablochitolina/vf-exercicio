package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.jpa.model.ItineraryEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ItineraryMapper {

    public static ItineraryEntity toEntity(ItineraryIntegrationDto dto) {

        return ItineraryEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .idLinha(dto.getIdLinha())
                .locations(dto.getLocations().stream().map(LocationMapper::toEntity).collect(Collectors.toList()))
                .build();
    }

    public static ItineraryIntegrationDto toDto(ItineraryEntity entity) {

        return ItineraryIntegrationDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .idLinha(entity.getIdLinha())
                .locations(entity.getLocations().stream().map(LocationMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}
