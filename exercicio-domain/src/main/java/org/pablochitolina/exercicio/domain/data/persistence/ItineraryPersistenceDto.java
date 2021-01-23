package org.pablochitolina.exercicio.domain.data.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ItineraryPersistenceDto {

    private Long id;
    private String codigo;
    private String nome;
    private List<LocationPersistenceDto> locations;

}
