package org.pablochitolina.exercicio.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LOCATION")
@Data
public class LocationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    Double lat;

    @Column
    Double lng;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "itinerary_id", nullable = false )
    private ItineraryJpaEntity itinerary;
}
