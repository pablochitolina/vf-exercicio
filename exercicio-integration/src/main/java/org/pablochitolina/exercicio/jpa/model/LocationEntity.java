package org.pablochitolina.exercicio.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LocationEntity {
    String lat;
    String lng;
}
