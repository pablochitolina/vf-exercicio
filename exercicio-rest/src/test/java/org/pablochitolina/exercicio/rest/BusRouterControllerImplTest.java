package org.pablochitolina.exercicio.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pablochitolina.exercicio.core.service.busroute.BusRouteService;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.rest.api.busroute.BusRouteAPI;
import org.pablochitolina.exercicio.rest.api.busroute.BusRouteControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BusRouteControllerImpl.class)
@ContextConfiguration(classes = {BusRouteAPI.class, BusRouteControllerImpl.class})
public class BusRouterControllerImplTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_CODIGO = "a-123";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BusRouteService busRouteService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void givenBusRoute_whenAddBusRoute_thenEntityIsPortedToService() throws Exception {
        var busRouterDto = BusRoutePersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/v1/routes")
                .content(objectMapper.writeValueAsString(busRouterDto))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(busRouteService, only()).addBusRoute(busRouterDto);
    }

}