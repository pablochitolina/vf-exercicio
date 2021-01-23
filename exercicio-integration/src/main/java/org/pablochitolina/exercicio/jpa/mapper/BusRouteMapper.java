package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.jpa.model.BusRouteEntity;
import org.springframework.stereotype.Component;

@Component
public class BusRouteMapper {

    public static BusRouteEntity toEntity(BusRouteIntegrationDto dto) {

        return BusRouteEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .id(dto.getId())
                .build();
    }

    public static BusRouteIntegrationDto toDto(BusRouteEntity entity) {

        return BusRouteIntegrationDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .id(entity.getId())
                .build();
    }
}
