package org.pablochitolina.exercicio.jpa.adapter;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.domain.data.persistence.LocationPersistenceDto;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryPersistencePort;
import org.pablochitolina.exercicio.jpa.mapper.ItineraryJpaMapper;
import org.pablochitolina.exercicio.jpa.model.ItineraryJpaEntity;
import org.pablochitolina.exercicio.jpa.repository.ItineraryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        ItineraryJpaAdapter.class,
        ItineraryPersistencePort.class})
public class ItineraryJpaAdapterTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";
    private static final Double TEST_LAT= -30.02639557701300000;
    private static final Double TEST_LNG = -51.22581910954200000;

    @Autowired
    private ItineraryPersistencePort itineraryPersistencePort;

    @MockBean
    private ItineraryJpaRepository itineraryJpaRepository;

    @Captor
    private ArgumentCaptor<ItineraryJpaEntity> itineraryJpaEntityArgumentCaptor;

    @Test
    void givenItinrary_whenAddItinerary_thenEntityIsPortedToRepository() {
        var locationsDto = Collections.singletonList(LocationPersistenceDto.builder()
                .lat(TEST_LAT)
                .lng(TEST_LNG)
                .build());

        var itineraryPersistenceDto = ItineraryPersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .busRouteId(1L)
                .locations(locationsDto)
                .build();

        when(itineraryJpaRepository.save(any())).thenReturn(ItineraryJpaMapper.toEntity(itineraryPersistenceDto));
        itineraryPersistencePort.addItinerary(itineraryPersistenceDto);

        verify(itineraryJpaRepository, only()).save(itineraryJpaEntityArgumentCaptor.capture());
        final var busRouteJpaEntity = itineraryJpaEntityArgumentCaptor.getValue();
        assertThat(busRouteJpaEntity.getNome()).isEqualTo(TEST_NOME);
        assertThat(busRouteJpaEntity.getCodigo()).isEqualTo(TEST_CODIGO);
        assertThat(busRouteJpaEntity.getBusRouteId()).isEqualTo(1L);
        assertThat(busRouteJpaEntity.getLocations().get(0).getLat()).isEqualTo(TEST_LAT);
        assertThat(busRouteJpaEntity.getLocations().get(0).getLng()).isEqualTo(TEST_LNG);
    }


}