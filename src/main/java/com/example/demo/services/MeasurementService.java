package com.example.demo.services;

import com.example.demo.models.Measurement;
import com.example.demo.models.Sensor;
import com.example.demo.repositories.MeasurementRepository;
import com.example.demo.repositories.SensorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Transactional
    public void addMeasurement(Double value, Boolean raining, String sensorName) {
        Sensor sensor = sensorRepository.findByName(sensorName)
                .orElseThrow(() -> new IllegalArgumentException("Sensor not found."));

        Measurement measurement = new Measurement();
        measurement.setValue(value);
        measurement.setRaining(raining);
        measurement.setSensor(sensor);
        measurementRepository.save(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public long getRainyDaysCount() {
        return measurementRepository.countByRainingTrue();
    }

}
