package org.pablochitolina.exercicio.domain.data.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BusRoutePersistenceDto {

    private Long id;

    @NotNull(message = "Codigo is required")
    @Size(min = 3, max = 20, message = "Codigo must have at least {min} and less than {max} length")
    private String codigo;

    @NotNull(message = "Nome is required")
    @Size(min = 3, max = 100, message = "Nome must have at least {min} and less than {max} length")
    private String nome;

}
