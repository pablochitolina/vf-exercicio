package org.pablochitolina.exercicio.integration.adapter;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.pablochitolina.exercicio.domain.port.busroute.BusRouteIntegrationPort;
import org.pablochitolina.exercicio.integration.model.BusRouteIntegrantionEntity;
import org.pablochitolina.exercicio.integration.repository.busroute.BusRouteIntegrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        BusRouteIntegrationAdapter.class,
        BusRouteIntegrationPort.class})
public class BusRouteIntegrationAdapterTest {

    private static final String TEST_ID = "123";
    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";

    @Autowired
    private BusRouteIntegrationPort busRouteIntegrationPort;

    @MockBean
    private BusRouteIntegrationRepository busRouteIntegrationRepository;

    @SneakyThrows
    @Test
    void givenCallToAllBusRoutes_whenNoParams_thenFindAllBusRoutesToRepository() {
        final var busRouteEntity = BusRouteIntegrantionEntity.builder()
                .id(TEST_ID)
                .nome(TEST_NOME)
                .codigo(TEST_CODIGO)
                .build();

        final var testBusRouteEntity = Collections.singletonList(busRouteEntity);
        when(busRouteIntegrationRepository.getAllBusRoutes()).thenReturn(testBusRouteEntity);

        final var allBusRoutes = busRouteIntegrationPort.getAllBusRoutes();

        verify(busRouteIntegrationRepository, only()).getAllBusRoutes();
        assertThat(allBusRoutes).hasSize(1);
        assertThat(allBusRoutes.get(0).getId()).isEqualTo(TEST_ID);
        assertThat(allBusRoutes.get(0).getNome()).isEqualTo(TEST_NOME);
        assertThat(allBusRoutes.get(0).getCodigo()).isEqualTo(TEST_CODIGO);
    }

}