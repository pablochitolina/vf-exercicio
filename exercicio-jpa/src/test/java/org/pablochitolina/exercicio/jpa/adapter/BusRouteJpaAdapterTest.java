package org.pablochitolina.exercicio.jpa.adapter;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.port.busroute.BusRoutePersistencePort;
import org.pablochitolina.exercicio.jpa.mapper.BusRouteJpaMapper;
import org.pablochitolina.exercicio.jpa.model.BusRouteJpaEntity;
import org.pablochitolina.exercicio.jpa.repository.BusRouteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        BusRouteJpaAdapter.class,
        BusRoutePersistencePort.class})
public class BusRouteJpaAdapterTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";

    @Autowired
    private BusRoutePersistencePort busRoutePersistencePort;

    @MockBean
    private BusRouteJpaRepository busRouteJpaRepository;

    @Captor
    private ArgumentCaptor<BusRouteJpaEntity> busRouteJpaEntityArgumentCaptor;

    @Test
    void givenBusRoute_whenAddBusRoutes_thenEntityIsPortedToRepository() {
        final var busRouterDto = BusRoutePersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

        when(busRouteJpaRepository.save(any())).thenReturn(BusRouteJpaMapper.toEntity(busRouterDto));
        busRoutePersistencePort.addBusRoute(busRouterDto);

        verify(busRouteJpaRepository, only()).save(busRouteJpaEntityArgumentCaptor.capture());
        final var busRouteJpaEntity = busRouteJpaEntityArgumentCaptor.getValue();
        assertThat(busRouteJpaEntity.getNome()).isEqualTo(TEST_NOME);
        assertThat(busRouteJpaEntity.getCodigo()).isEqualTo(TEST_CODIGO);
    }


}