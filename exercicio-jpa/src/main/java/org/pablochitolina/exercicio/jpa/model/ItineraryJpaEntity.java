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
public class ItineraryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String codigo;

    @Column
    private String nome;

    @Column
    private Long busRouteId;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "itinerary")
    @Column(nullable = false)
    private List<LocationJpaEntity> locations;

}
