package sensorsApp.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import sensorsApp.dto.MeasurementDto;
import sensorsApp.dto.RainyDaysDto;
import sensorsApp.mappres.MeasurementMapper;
import sensorsApp.repositories.MeasurementRepository;

import java.util.List;

/**
 * Measurement service class
 */
@Slf4j
@RequiredArgsConstructor
@Service
@Validated
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    /**
     * Save new measurement
     * @param measurementDto measurement data
     */
    @Transactional
    public void addMeasurement(@Validated MeasurementDto measurementDto) {

        log.info("Called MeasurementService.addMeasurement method with measurementDto is: {}", measurementDto);
        measurementRepository.save(measurementMapper.toEntity(measurementDto));
    }

    /**
     * Get all measurements
     * @return All measurements from DB - List with MeasurementDto
     */
    public List<MeasurementDto> getAllMeasurements() {

        log.info("Called MeasurementService.getAllMeasurements");

        return measurementMapper.toMeasurementsList(measurementRepository.findAll());
    }

    /**
     * Get rainy days count
     * @return long value
     */
    public RainyDaysDto getRainyDaysCount() {

        log.info("Called MeasurementService.getRainyDaysCount");

        return new RainyDaysDto(measurementRepository.countByRainingTrue());
    }
}