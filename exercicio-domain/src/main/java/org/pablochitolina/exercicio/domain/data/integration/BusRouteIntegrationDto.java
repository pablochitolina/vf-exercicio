package org.pablochitolina.exercicio.domain.data.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BusRouteIntegrationDto {

    private String id;
    private String codigo;
    private String nome;

}
