package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.persistence.LocationPersistenceDto;
import org.pablochitolina.exercicio.jpa.model.LocationJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationJpaMapper {

    public static LocationJpaEntity toEntity(LocationPersistenceDto dto) {

        return LocationJpaEntity
                .builder()
                .id(dto.getId())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .build();
    }

    public static LocationPersistenceDto toDto(LocationJpaEntity entity) {

        return LocationPersistenceDto
                .builder()
                .id(entity.getId())
                .lat(entity.getLat())
                .lng(entity.getLng())
                .build();
    }
}
