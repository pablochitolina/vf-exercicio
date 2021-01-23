package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.persistence.LocationPersistenceDto;
import org.pablochitolina.exercicio.jpa.model.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public static LocationEntity toEntity(LocationPersistenceDto dto) {

        return LocationEntity
                .builder()
                .id(dto.getId())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .build();
    }

    public static LocationPersistenceDto toDto(LocationEntity entity) {

        return LocationPersistenceDto
                .builder()
                .id(entity.getId())
                .lat(entity.getLat())
                .lng(entity.getLng())
                .build();
    }
}
