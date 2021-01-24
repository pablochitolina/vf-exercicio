package org.pablochitolina.exercicio.integration.repository.itinerary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.pablochitolina.exercicio.integration.model.ItineraryIntegrantionEntity;
import org.pablochitolina.exercicio.integration.model.LocationIntegrantionEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ItineraryIntegrationRepositoryImpl implements ItineraryIntegrationRepository {

    public static final String URL_LIST_BUS_ROUTES = "http://www.poatransporte.com.br/php/facades/process.php";

    @Override
    public ItineraryIntegrantionEntity getBusItineraryByUnit(String unit) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try{

            URIBuilder builder = new URIBuilder(URL_LIST_BUS_ROUTES);
            builder.setParameter("a", "il")
                    .setParameter("p", unit);

            HttpGet request = new HttpGet(builder.build());
            request.addHeader("accept", "application/json");

            CloseableHttpResponse response = httpClient.execute(request);

            try{

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    String json = EntityUtils.toString(entity);

                    ItineraryIntegrantionEntity responseObject = new Gson().fromJson(json, ItineraryIntegrantionEntity.class);
                    responseObject.setLocations(populateLocations(json));

                    return responseObject;
                }

            }finally {
                response.close();
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }finally {
            httpClient.close();
        }

        return null;
    }

    private List<LocationIntegrantionEntity> populateLocations(String json){

        List<LocationIntegrantionEntity> locationEntities = new ArrayList<>();

        int index = 0;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json);

            while(node.hasNonNull(String.valueOf(index))){
                locationEntities.add(new LocationIntegrantionEntity(
                        node.get(String.valueOf(index)).get("lat").asText(),
                        node.get(String.valueOf(index)).get("lng").asText()));
                index ++;
            }

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return locationEntities;

    }


}
