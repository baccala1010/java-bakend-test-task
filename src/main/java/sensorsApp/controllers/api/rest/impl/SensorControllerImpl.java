package sensorsApp.controllers.api.rest.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sensorsApp.controllers.api.rest.SensorController;
import sensorsApp.dto.SensorDto;
import sensorsApp.exceptions.SensorCreateException;
import sensorsApp.services.SensorService;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Sensor endpoint implementation
 */
@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorControllerImpl implements SensorController {

    private final SensorService sensorService;

    @Override
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid SensorDto sensorDto) throws SensorCreateException {

        sensorService.create(sensorDto);

        return new ResponseEntity<>(CREATED);
    }
}