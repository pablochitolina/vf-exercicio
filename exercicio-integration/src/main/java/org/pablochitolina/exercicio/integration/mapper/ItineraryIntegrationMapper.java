package org.pablochitolina.exercicio.integration.mapper;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.integration.model.ItineraryIntegrantionEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ItineraryIntegrationMapper {

    public static ItineraryIntegrantionEntity toEntity(ItineraryIntegrationDto dto) {

        return ItineraryIntegrantionEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .idLinha(dto.getIdLinha())
                .locations(dto.getLocations().stream().map(LocationIntegrationMapper::toEntity).collect(Collectors.toList()))
                .build();
    }

    public static ItineraryIntegrationDto toDto(ItineraryIntegrantionEntity entity) {

        return ItineraryIntegrationDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .idLinha(entity.getIdLinha())
                .locations(entity.getLocations().stream().map(LocationIntegrationMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}
