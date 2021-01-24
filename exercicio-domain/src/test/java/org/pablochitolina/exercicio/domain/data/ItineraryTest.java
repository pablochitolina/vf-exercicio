package org.pablochitolina.exercicio.domain.data;

import org.junit.jupiter.api.Test;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.domain.data.persistence.LocationPersistenceDto;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ItineraryTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";
    private static final Double TEST_LAT= -30.02639557701300000;
    private static final Double TEST_LNG = -51.22581910954200000;

    @Test
    public void givenName_whenLyricsWithName_thenNameIsSet() {
        var locationsDto = Collections.singletonList(LocationPersistenceDto.builder()
                .lat(TEST_LAT)
                .lng(TEST_LNG)
                .build());

        var itineraryDto = ItineraryPersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .busRouteId(1L)
                .locations(locationsDto)
                .build();

        assertThat(itineraryDto.getCodigo()).isEqualTo(TEST_CODIGO);
        assertThat(itineraryDto.getNome()).isEqualTo(TEST_NOME);
        assertThat(itineraryDto.getBusRouteId()).isEqualTo(1L);
        assertThat(itineraryDto.getLocations().get(0).getLat()).isEqualTo(TEST_LAT);
        assertThat(itineraryDto.getLocations().get(0).getLng()).isEqualTo(TEST_LNG);
    }

}