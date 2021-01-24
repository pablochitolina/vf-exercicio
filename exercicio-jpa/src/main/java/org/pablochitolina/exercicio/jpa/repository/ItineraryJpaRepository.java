package org.pablochitolina.exercicio.jpa.repository;

import org.pablochitolina.exercicio.jpa.model.ItineraryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItineraryJpaRepository extends JpaRepository<ItineraryJpaEntity, Long> {

    Optional<ItineraryJpaEntity> findItineraryByBusRouteId(Long id);

}
