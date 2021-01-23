package org.pablochitolina.exercicio.jpa.model;

import lombok.*;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BusRouteEntity {

    private String id;
    private String codigo;
    private String nome;

}
