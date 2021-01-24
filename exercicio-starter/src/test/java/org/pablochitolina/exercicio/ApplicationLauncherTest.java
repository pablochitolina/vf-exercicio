package org.pablochitolina.exercicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.pablochitolina.exercicio.domain.data.persistence.LocationPersistenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationLauncherTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_NOME_EDT = "Nome Edt";
    private static final String TEST_CODIGO = "a-123";
    private static final Double TEST_LAT= -30.02639557701300000;
    private static final Double TEST_LAT_EDT= 10.747293874900000;
    private static final Double TEST_LNG = -51.22581910954200000;

    @Autowired
    private MockMvc mvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void givenBusRoute_whenAddAndUpdateAndThenRemoveBusRoute_thenEntity() throws Exception {
        var busRouterDto = BusRoutePersistenceDto.builder()
                .codigo(TEST_CODIGO)
                .nome(TEST_NOME)
                .build();

         mvc.perform(MockMvcRequestBuilders.post("/v1/routes")
                .content(objectMapper.writeValueAsString(busRouterDto))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/routes/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value(TEST_CODIGO))
                .andExpect(jsonPath("$.nome").value(TEST_NOME));

        busRouterDto.setNome(TEST_NOME_EDT);
        busRouterDto.setId(2L);

        mvc.perform(MockMvcRequestBuilders.post("/v1/routes")
                .content(objectMapper.writeValueAsString(busRouterDto))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/routes/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value(TEST_CODIGO))
                .andExpect(jsonPath("$.nome").value(TEST_NOME_EDT));

        mvc.perform(MockMvcRequestBuilders.delete("/v1/routes/2")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/routes/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void givenItinerary_whenAddAndUpdateAndThenRemoveItinerary_thenEntity() throws Exception {

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

        mvc.perform(MockMvcRequestBuilders.post("/v1/itineraries")
                .content(objectMapper.writeValueAsString(itineraryDto))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/itineraries/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value(TEST_CODIGO))
                .andExpect(jsonPath("$.nome").value(TEST_NOME))
                .andExpect(jsonPath("$.busRouteId").value(1L))
                .andExpect(jsonPath("$.locations[0].lat").value(TEST_LAT))
                .andExpect(jsonPath("$.locations[0].lng").value(TEST_LNG));

        itineraryDto.setNome(TEST_NOME_EDT);
        itineraryDto.setId(2L);
        itineraryDto.getLocations().get(0).setId(1L);
        itineraryDto.getLocations().get(0).setLat(TEST_LAT_EDT);

        mvc.perform(MockMvcRequestBuilders.post("/v1/itineraries")
                .content(objectMapper.writeValueAsString(itineraryDto))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/itineraries/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value(TEST_CODIGO))
                .andExpect(jsonPath("$.nome").value(TEST_NOME_EDT))
                .andExpect(jsonPath("$.busRouteId").value(1L))
                .andExpect(jsonPath("$.locations[0].lat").value(TEST_LAT_EDT))
                .andExpect(jsonPath("$.locations[0].lng").value(TEST_LNG));

        mvc.perform(MockMvcRequestBuilders.delete("/v1/itineraries/2")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/itineraries/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}