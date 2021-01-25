package org.pablochitolina.exercicio.integration.repository.busroute;

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
import org.pablochitolina.exercicio.integration.model.BusRouteIntegrantionEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Repository
@Slf4j
public class BusRouteIntegrationRepositoryImpl implements BusRouteIntegrationRepository {

    public static final String URL_LIST_BUS_ROUTES = "http://www.poatransporte.com.br/php/facades/process.php";


    @Override
    public List<BusRouteIntegrantionEntity> getAllBusRoutes() {

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
                    return new Gson().fromJson(json, new TypeToken<List<BusRouteIntegrantionEntity>>(){}.getType());
                }

            }finally {
                response.close();
            }

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

}
