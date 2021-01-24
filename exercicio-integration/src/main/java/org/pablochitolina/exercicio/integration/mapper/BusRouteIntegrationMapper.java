package org.pablochitolina.exercicio.integration.mapper;

import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.integration.model.BusRouteIntegrantionEntity;
import org.springframework.stereotype.Component;

@Component
public class BusRouteIntegrationMapper {

    public static BusRouteIntegrantionEntity toEntity(BusRouteIntegrationDto dto) {

        return BusRouteIntegrantionEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .id(dto.getId())
                .build();
    }

    public static BusRouteIntegrationDto toDto(BusRouteIntegrantionEntity entity) {

        return BusRouteIntegrationDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .id(entity.getId())
                .build();
    }
}
