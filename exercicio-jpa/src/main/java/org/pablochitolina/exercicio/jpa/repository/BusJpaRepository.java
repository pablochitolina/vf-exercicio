package org.pablochitolina.exercicio.jpa.repository;

import org.pablochitolina.exercicio.jpa.model.BusRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BusJpaRepository extends JpaRepository<BusRouteEntity, Long> {

    //LyricsEntity findByLyrics(String Lyrics);
}
