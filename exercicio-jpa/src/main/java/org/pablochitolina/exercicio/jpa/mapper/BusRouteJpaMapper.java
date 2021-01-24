package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.jpa.model.BusRouteJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class BusRouteJpaMapper {

    public static BusRouteJpaEntity toEntity(BusRoutePersistenceDto dto) {

        return BusRouteJpaEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .id(dto.getId())
                .build();
    }

    public static BusRoutePersistenceDto toDto(BusRouteJpaEntity entity) {

        return BusRoutePersistenceDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .id(entity.getId())
                .build();
    }
}
