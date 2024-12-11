package com.example.demo.services;

import com.example.demo.models.Sensor;
import com.example.demo.repositories.SensorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Transactional
    public void registerSensor(String sensorName){

        validateSensorName(sensorName);
        validateSensorDoesNotExist(sensorName);

        Sensor newSensor = new Sensor();
        newSensor.setName(sensorName);
        sensorRepository.save(newSensor);

    }

    private void validateSensorDoesNotExist(String sensorName){
        if(sensorRepository.findByName(sensorName).isPresent()){
            throw new IllegalArgumentException("The sensor "+sensorName+" exists.");
        }
    }

    private void validateSensorName(String sensorName){
        if (sensorName == null || sensorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Sensor name can not be null or empty.");
        }
    }

}
