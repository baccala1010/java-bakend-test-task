package sensorsApp.controllers.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sensorsApp.dto.SensorDto;
import sensorsApp.exceptions.SensorCreateException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Sensors endpoint interface
 */
@Tag(name = "Sensors", description = "Endpoint for sensors")
public interface SensorController {

    @Operation(summary = "Save sensor to DB")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Sensor saved")})
    @PostMapping(value = "/registration", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<HttpStatus> create(@RequestBody SensorDto sensorDto) throws SensorCreateException;
}