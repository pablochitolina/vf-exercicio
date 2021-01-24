package org.pablochitolina.exercicio.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LocationIntegrantionEntity {
    String lat;
    String lng;
}
