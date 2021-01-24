package org.pablochitolina.exercicio.integration.mapper;

import org.pablochitolina.exercicio.domain.data.integration.LocationIntegrationDto;
import org.pablochitolina.exercicio.integration.model.LocationIntegrantionEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationIntegrationMapper {

    public static LocationIntegrantionEntity toEntity(LocationIntegrationDto dto) {

        return LocationIntegrantionEntity
                .builder()
                .lat(dto.getLat())
                .lng(dto.getLng())
                .build();
    }

    public static LocationIntegrationDto toDto(LocationIntegrantionEntity entity) {

        return LocationIntegrationDto
                .builder()
                .lat(entity.getLat())
                .lng(entity.getLng())
                .build();
    }
}
