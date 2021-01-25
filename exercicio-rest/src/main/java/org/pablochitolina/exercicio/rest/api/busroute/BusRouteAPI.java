package org.pablochitolina.exercicio.rest.api.busroute;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.pablochitolina.exercicio.domain.data.integration.BusRouteIntegrationDto;
import org.pablochitolina.exercicio.domain.data.integration.ItineraryIntegrationDto;
import org.pablochitolina.exercicio.domain.data.persistence.BusRoutePersistenceDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(produces = MediaType.APPLICATION_JSON_VALUE)
public interface BusRouteAPI {

    @ApiOperation(value = "Operation to GET all Bus Routes from External API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = BusRouteIntegrationDto[].class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<List<BusRouteIntegrationDto>> getAllBusRoutesIntegration();

    @ApiOperation(value = "Operation to GET Bus Routes by Name from External API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = BusRouteIntegrationDto[].class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<List<BusRouteIntegrationDto>> getBusRoutesByName(@PathVariable String name);

    @ApiOperation(value = "Operation to POST or UPDATE (if ID exists) a Bus Route")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = BusRouteIntegrationDto.class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<BusRoutePersistenceDto> addBusRoute(@Valid @RequestBody BusRoutePersistenceDto busRoutePersistenceDtoS);

    @ApiOperation(value = "Operation to DELETE a Bus Route")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Successful Request"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<Void> removeBusRoute(@PathVariable Long id);

    @ApiOperation(value = "Operation to GET all Bus Routes from Internal Database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = BusRouteIntegrationDto[].class),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<List<BusRoutePersistenceDto>> getAllBusRoutesPersistence();

    @ApiOperation(value = "Operation to GET a Bus Routes by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Request", response = BusRouteIntegrationDto.class),
            @ApiResponse(code = 204, message = "Bus Route Not Found"),
            @ApiResponse(code = 500, message = "Unexpected Error")
    })
    ResponseEntity<BusRoutePersistenceDto> getBusRouteById(@PathVariable Long id);

}
