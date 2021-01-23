package org.pablochitolina.exercicio.domain.data.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LocationIntegrationDto {

    String lat;
    String lng;

}
