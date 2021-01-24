package org.pablochitolina.exercicio.jpa.repository;

import org.pablochitolina.exercicio.jpa.model.BusRouteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusJpaRepository extends JpaRepository<BusRouteJpaEntity, Long> {

    //LyricsEntity findByLyrics(String Lyrics);
}
