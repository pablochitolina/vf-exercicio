package org.pablochitolina.exercicio.domain.data.persistence;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ItineraryPersistenceDto {

    private Long id;

    @NotNull(message = "Codigo is required")
    @Size(min = 3, max = 20, message = "Codigo must have at least {min} and less than {max} length")
    private String codigo;

    @NotNull(message = "Nome is required")
    @Size(min = 3, max = 100, message = "Nome must have at least {min} and less than {max} length")
    private String nome;

    @NotNull(message = "Bus Route Id is required")
    private Long busRouteId;

    @NotNull(message = "Locations are required")
    private List<LocationPersistenceDto> locations;

}
