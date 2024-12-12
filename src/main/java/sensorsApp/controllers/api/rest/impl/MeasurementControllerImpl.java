package sensorsApp.controllers.api.rest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sensorsApp.controllers.api.rest.MeasurementController;
import sensorsApp.dto.MeasurementDto;
import sensorsApp.dto.RainyDaysDto;
import sensorsApp.services.MeasurementService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * Measurement endpoint implementation
 */
@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor
public class MeasurementControllerImpl implements MeasurementController {

    private final MeasurementService measurementService;

    @Override
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody MeasurementDto measurementDto) {

        measurementService.addMeasurement(measurementDto);

        return new ResponseEntity<>(CREATED);
    }

    @Override
    public ResponseEntity<List<MeasurementDto>> getAll() {

        return ResponseEntity.status(OK).body(measurementService.getAllMeasurements());
    }

    @Override
    public ResponseEntity<RainyDaysDto> getRainyDaysCount() {

        return ResponseEntity.status(OK).body(measurementService.getRainyDaysCount());
    }
}