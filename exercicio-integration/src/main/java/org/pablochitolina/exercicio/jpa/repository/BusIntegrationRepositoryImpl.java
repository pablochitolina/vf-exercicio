package org.pablochitolina.exercicio.jpa.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.pablochitolina.exercicio.jpa.model.BusRouteEntity;
import org.pablochitolina.exercicio.jpa.model.ItineraryEntity;
import org.pablochitolina.exercicio.jpa.model.LocationEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class BusIntegrationRepositoryImpl implements BusIntegrationRepository {

    public static final String URL_LIST_BUS_ROUTES = "http://www.poatransporte.com.br/php/facades/process.php";


    @Override
    public List<BusRouteEntity> getAllBusRoutes() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try{

            URIBuilder builder = new URIBuilder(URL_LIST_BUS_ROUTES);
            builder.setParameter("a", "nc")
                    .setParameter("p", "%")
                    .setParameter("t", "o");

            HttpGet request = new HttpGet(builder.build());
            request.addHeader("accept", "application/json");


            CloseableHttpResponse response = httpClient.execute(request);

            try{

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    String json = EntityUtils.toString(entity);
                    return new Gson().fromJson(json, new TypeToken<List<BusRouteEntity>>(){}.getType());
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

    @Override
    public ItineraryEntity getBusItineraryByUnit(String unit) throws IOException {

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

                    ItineraryEntity responseObject = new Gson().fromJson(json, ItineraryEntity.class);
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

    private List<LocationEntity> populateLocations(String json){

        List<LocationEntity> locationEntities = new ArrayList<>();

        int index = 0;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json);

            while(node.hasNonNull(String.valueOf(index))){
                locationEntities.add(new LocationEntity(
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
