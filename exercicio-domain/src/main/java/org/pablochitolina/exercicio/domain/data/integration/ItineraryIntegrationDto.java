package org.pablochitolina.exercicio.domain.data.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ItineraryIntegrationDto {

    private String idLinha;
    private String codigo;
    private String nome;
    private List<LocationIntegrationDto> locations;

}
