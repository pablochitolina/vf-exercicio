package org.pablochitolina.exercicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationLauncherTest {

    private static final String TEST_NOME = "Nome";
    private static final String TEST_NOME_EDT = "Nome Edt";
    private static final String TEST_CODIGO = "a-123";

    @Autowired
    private MockMvc mvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void givenBusRoute_whenAddAndUpdateAndThenRemoveBusRoute_thenEntity() throws Exception {
        final var busRouterDto = BusRoutePersistenceDto.builder()
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
                .andExpect(jsonPath("$.codigo").exists())
                .andExpect(jsonPath("$.codigo").value(TEST_CODIGO))
                .andExpect(jsonPath("$.nome").exists())
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
                .andExpect(jsonPath("$.codigo").exists())
                .andExpect(jsonPath("$.codigo").value(TEST_CODIGO))
                .andExpect(jsonPath("$.nome").exists())
                .andExpect(jsonPath("$.nome").value(TEST_NOME_EDT));

        mvc.perform(MockMvcRequestBuilders.delete("/v1/routes/2")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/v1/routes/2")
                .accept(APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}