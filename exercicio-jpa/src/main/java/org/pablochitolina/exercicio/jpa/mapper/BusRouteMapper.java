package org.pablochitolina.exercicio.jpa.mapper;

import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.jpa.model.BusRouteEntity;
import org.springframework.stereotype.Component;

@Component
public class BusRouteMapper {

    public static BusRouteEntity toEntity(BusRoutePersistenceDto dto) {

        return BusRouteEntity
                .builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .id(dto.getId())
                .itinerary(ItineraryMapper.toEntity(dto.getItinerary()))
                .build();
    }

    public static BusRoutePersistenceDto toDto(BusRouteEntity entity) {

        return BusRoutePersistenceDto
                .builder()
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .id(entity.getId())
                .itinerary(ItineraryMapper.toDto(entity.getItinerary()))
                .build();
    }
}
