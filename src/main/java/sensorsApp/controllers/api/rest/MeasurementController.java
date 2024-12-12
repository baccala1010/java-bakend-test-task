package sensorsApp.controllers.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sensorsApp.dto.MeasurementDto;
import sensorsApp.dto.RainyDaysDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Measurement endpoint interface
 */
@Tag(name = "Measurements", description = "Endpoint for measurements")
public interface MeasurementController {
    @Operation(summary = "Save measurement to DB")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Measurement saved")})
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<HttpStatus> addMeasurement(@RequestBody MeasurementDto measurementDto);

    @Operation(summary = "Get all measurement data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "All measurements data got")})
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<MeasurementDto>> getAll();

    @Operation(summary = "Get rainy days count")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Rainy days count got")})
    @GetMapping(value = "/rainyDaysCount", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<RainyDaysDto> getRainyDaysCount();
}