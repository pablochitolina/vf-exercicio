package org.pablochitolina.exercicio.jpa.adapter;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.domain.port.itinerary.ItineraryPersistencePort;
import org.pablochitolina.exercicio.jpa.model.ItineraryJpaEntity;
import org.pablochitolina.exercicio.jpa.repository.ItineraryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {
        ItineraryJpaAdapter.class,
        ItineraryPersistencePort.class})
public class ItineraryJpaAdapterTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";

    @Autowired
    private ItineraryPersistencePort itineraryPersistencePort;

    @MockBean
    private ItineraryJpaRepository itineraryJpaRepository;

    @Captor
    private ArgumentCaptor<ItineraryJpaEntity> itineraryJpaEntityArgumentCaptor;

    @Test
    void givenItinrary_whenAddItinerary_thenEntityIsPortedToRepository() {
        var itineraryPersistenceDto = ItineraryPersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

        itineraryPersistencePort.addItinerary(itineraryPersistenceDto);

        verify(itineraryJpaRepository, only()).save(itineraryJpaEntityArgumentCaptor.capture());
        final var busRouteJpaEntity = itineraryJpaEntityArgumentCaptor.getValue();
        assertThat(busRouteJpaEntity.getNome()).isEqualTo(TEST_NOME);
        assertThat(busRouteJpaEntity.getCodigo()).isEqualTo(TEST_CODIGO);
    }


}