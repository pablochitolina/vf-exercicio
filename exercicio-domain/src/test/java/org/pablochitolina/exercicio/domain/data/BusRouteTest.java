package org.pablochitolina.exercicio.domain.data;

import org.junit.jupiter.api.Test;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;

import static org.assertj.core.api.Assertions.assertThat;

public class BusRouteTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";

    @Test
    public void givenName_whenLyricsWithName_thenNameIsSet() {

        var busRoutePersistenceDto = BusRoutePersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

        assertThat(busRoutePersistenceDto.getCodigo()).isEqualTo(TEST_CODIGO);
        assertThat(busRoutePersistenceDto.getNome()).isEqualTo(TEST_NOME);

    }
    
}