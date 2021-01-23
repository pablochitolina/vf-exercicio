package org.pablochitolina.exercicio.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ITINERARY")
@Data
public class ItineraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String codigo;

    @Column
    private String nome;

    @OneToOne(mappedBy = "itinerary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BusRouteEntity busRoute;

    @OneToMany(mappedBy = "itinerary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LocationEntity> locations;

}
