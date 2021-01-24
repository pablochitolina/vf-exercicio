package org.pablochitolina.exercicio.rest.api.itinerary;

import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/v1/itinerary")
public interface ItineraryController {

    @GetMapping("/integration/{unit}")
    ResponseEntity<ItineraryIntegrationDto> getBusItineraryByUnit(@PathVariable String unit);


}
