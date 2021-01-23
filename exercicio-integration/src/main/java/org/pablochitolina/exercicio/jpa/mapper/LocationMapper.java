package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.integration.LocationIntegrationDto;
import org.pablochitolina.exercicio.jpa.model.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public static LocationEntity toEntity(LocationIntegrationDto dto) {

        return LocationEntity
                .builder()
                .lat(dto.getLat())
                .lng(dto.getLng())
                .build();
    }

    public static LocationIntegrationDto toDto(LocationEntity entity) {

        return LocationIntegrationDto
                .builder()
                .lat(entity.getLat())
                .lng(entity.getLng())
                .build();
    }
}
