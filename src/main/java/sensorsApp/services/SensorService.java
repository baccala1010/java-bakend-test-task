package sensorsApp.services;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sensorsApp.dto.SensorDto;
import sensorsApp.exceptions.SensorCreateException;
import sensorsApp.mappres.SensorMapper;
import sensorsApp.repositories.SensorRepository;

/**
 * Sensor service class
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    /**
     * Add sensor to DB
     * @param sensorDto with sensor data
     * @throws SensorCreateException if sensor can't be saved
     */
    @Transactional
    public void create(SensorDto sensorDto) throws SensorCreateException {

        log.info("Called SensorService.create method with sensorDto is: {}", sensorDto);

        try {
            sensorRepository.save(sensorMapper.toEntity(sensorDto));
        } catch (ConstraintViolationException e) {
            throw new SensorCreateException();
        }
    }
}