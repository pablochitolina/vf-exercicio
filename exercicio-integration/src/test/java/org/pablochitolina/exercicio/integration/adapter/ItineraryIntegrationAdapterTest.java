package org.pablochitolina.exercicio.integration.adapter;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.pablochitolina.exercicio.domain.port.busroute.BusRouteIntegrationPort;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryIntegrationPort;
import org.pablochitolina.exercicio.integration.model.ItineraryIntegrantionEntity;
import org.pablochitolina.exercicio.integration.model.LocationIntegrantionEntity;
import org.pablochitolina.exercicio.integration.repository.itinerary.ItineraryIntegrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        BusRouteIntegrationAdapter.class,
        BusRouteIntegrationPort.class})
public class ItineraryIntegrationAdapterTest {

    private static final String TEST_ID = "123";
    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";
    private static final String TEST_LAT = "-30.01833657701300000";
    private static final String TEST_LNG = "-51.20937010954200000";


    @Autowired
    private ItineraryIntegrationPort itineraryIntegrationPort;

    @MockBean
    private ItineraryIntegrationRepository itineraryIntegrationRepository;

    @SneakyThrows
    @Test
    void givenUnit_whenCallingGetBusItineraryByUnit_thenFindByUnitToRepository() {

        final var itineraryList = Collections.singletonList(LocationIntegrantionEntity.builder().lat(TEST_LAT).lng(TEST_LNG).build());
        final var testItinerary = ItineraryIntegrantionEntity.builder()
                .locations(itineraryList)
                .idLinha(TEST_ID)
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

        when(itineraryIntegrationRepository.getBusItineraryByUnit(TEST_ID)).thenReturn(testItinerary);

        final var itineraryDto = itineraryIntegrationPort.getBusItineraryByUnit(TEST_ID);

        verify(itineraryIntegrationRepository, only()).getBusItineraryByUnit(TEST_ID);
        assertThat(itineraryDto.getCodigo()).isEqualTo(TEST_CODIGO);
        assertThat(itineraryDto.getIdLinha()).isEqualTo(TEST_ID);
        assertThat(itineraryDto.getNome()).isEqualTo(TEST_NOME);
        assertThat(itineraryDto.getLocations()).hasSize(1);
        assertThat(itineraryDto.getLocations().get(0).getLat()).isEqualTo(TEST_LAT);
        assertThat(itineraryDto.getLocations().get(0).getLng()).isEqualTo(TEST_LNG);
    }
}