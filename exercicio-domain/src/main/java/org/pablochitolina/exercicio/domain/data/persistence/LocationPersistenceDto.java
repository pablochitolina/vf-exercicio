package org.pablochitolina.exercicio.domain.data.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class LocationPersistenceDto {

    Long id;

    @NotNull(message = "Latitude is required")
    Double lat;

    @NotNull(message = "Longitude is required")
    Double lng;

}
