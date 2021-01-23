package org.pablochitolina.exercicio.jpa.adapter;

import lombok.SneakyThrows;
import org.pablochitolina.exercicio.domain.port.BusIntegrationPort;
import org.pablochitolina.exercicio.jpa.model.BusRouteEntity;
import org.pablochitolina.exercicio.jpa.model.ItineraryEntity;
import org.pablochitolina.exercicio.jpa.model.LocationEntity;
import org.pablochitolina.exercicio.jpa.repository.BusIntegrationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        BusIntegrationAdapter.class,
        BusIntegrationPort.class})
public class BusIntegrationAdapterTest {

    private static final String TEST_ID = "123";
    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";
    private static final String TEST_LAT = "-30.01833657701300000";
    private static final String TEST_LNG = "-51.20937010954200000";


    @Autowired
    private BusIntegrationPort busIntegrationPort;

    @MockBean
    private BusIntegrationRepository busIntegrationRepository;

    @Captor
    private ArgumentCaptor<BusRouteEntity> busRouteEntityArgumentCaptor;

    @SneakyThrows
    @Test
    void givenCallToAllBusRoutes_whenNoParams_thenFindAllBusRoutesToRepository() {
        final var busRouteEntity = BusRouteEntity.builder()
                .id(TEST_ID)
                .nome(TEST_NOME)
                .codigo(TEST_CODIGO)
                .build();

        final var testBusRouteEntity = Collections.singletonList(busRouteEntity);
        when(busIntegrationRepository.getAllBusRoutes()).thenReturn(testBusRouteEntity);

        final var allBusRoutes = busIntegrationPort.getAllBusRoutes();

        verify(busIntegrationRepository, only()).getAllBusRoutes();
        assertThat(allBusRoutes).hasSize(1);
        assertThat(allBusRoutes.get(0).getId()).isEqualTo(TEST_ID);
        assertThat(allBusRoutes.get(0).getNome()).isEqualTo(TEST_NOME);
        assertThat(allBusRoutes.get(0).getCodigo()).isEqualTo(TEST_CODIGO);
    }

    @SneakyThrows
    @Test
    void givenUnit_whenCallingGetBusItineraryByUnit_thenFindByUnitToRepository() {

        final var itineraryList = Collections.singletonList(LocationEntity.builder().lat(TEST_LAT).lng(TEST_LNG).build());
        final var testItinerary = ItineraryEntity.builder()
                .locations(itineraryList)
                .idLinha(TEST_ID)
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

        when(busIntegrationRepository.getBusItineraryByUnit(TEST_ID)).thenReturn(testItinerary);

        final var itineraryDto = busIntegrationPort.getBusItineraryByUnit(TEST_ID);

        verify(busIntegrationRepository, only()).getBusItineraryByUnit(TEST_ID);
        assertThat(itineraryDto.getCodigo()).isEqualTo(TEST_CODIGO);
        assertThat(itineraryDto.getIdLinha()).isEqualTo(TEST_ID);
        assertThat(itineraryDto.getNome()).isEqualTo(TEST_NOME);
        assertThat(itineraryDto.getLocations()).hasSize(1);
        assertThat(itineraryDto.getLocations().get(0).getLat()).isEqualTo(TEST_LAT);
        assertThat(itineraryDto.getLocations().get(0).getLng()).isEqualTo(TEST_LNG);
    }
}