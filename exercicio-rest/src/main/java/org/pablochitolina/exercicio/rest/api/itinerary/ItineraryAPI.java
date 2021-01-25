package org.pablochitolina.exercicio.rest.api.itinerary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.ItineraryPersistenceDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(produces = MediaType.APPLICATION_JSON_VALUE)
public interface ItineraryAPI {

    @ApiOperation(value = "Operation to GET a Itinerary by Bus Route ID from External API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = ItineraryIntegrationDto.class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<ItineraryIntegrationDto> getBusItineraryByUnit(@PathVariable String unit);

    @ApiOperation(value = "Operation to POST or UPDATE (if ID exists) a Itinerary")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = ItineraryIntegrationDto.class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<ItineraryPersistenceDto> addItinerary(@RequestBody ItineraryPersistenceDto itineraryIntegrationDto);

    @ApiOperation(value = "Operation to DELETE a Itinerary")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Successful Request"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<Void> removeItinerary(@PathVariable Long id);

    @ApiOperation(value = "Operation to GET a Itinerary by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = ItineraryIntegrationDto.class),
            @ApiResponse(code = 204, message = "Itinerary Not Found"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<ItineraryPersistenceDto> getItineraryById(@PathVariable Long id);

    @ApiOperation(value = "Operation to GET all Itineraries")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = ItineraryPersistenceDto[].class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<List<ItineraryPersistenceDto>> getAllItineraries();

    @ApiOperation(value = "Operation to GET a Itinerary by Bus Route ID from Internal DataBase")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = ItineraryIntegrationDto.class),
            @ApiResponse(code = 204, message = "Itinerary Not Found"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<ItineraryPersistenceDto> getItineraryByBusRouteId(@PathVariable Long id);

    @ApiOperation(value = "Operation to GET all Itineraries that contains any Location Point inside a range")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = ItineraryPersistenceDto[].class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<List<ItineraryPersistenceDto>> getItinerariesByRange(@RequestParam Double lat, @RequestParam Double lng, @RequestParam Double range);

}
