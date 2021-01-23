package org.pablochitolina.exercicio.domain.data.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BusRoutePersistenceDto {

    private Long id;
    private String codigo;
    private String nome;
    private ItineraryPersistenceDto itinerary;

}
