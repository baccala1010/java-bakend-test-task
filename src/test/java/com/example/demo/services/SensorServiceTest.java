package com.example.demo.services;

import com.example.demo.models.Sensor;
import com.example.demo.repositories.SensorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SensorServiceTest {

    @Mock
    private SensorRepository sensorRepositoryMock;

    @InjectMocks
    private SensorService sensorServiceMock;

    @Test
    public void SensorService_RegisterSensor_ReturnsSuccess(){

        String sensorNameValid = "ValidSensor";
        when(sensorRepositoryMock.findByName(sensorNameValid)).thenReturn(Optional.empty());
        when(sensorRepositoryMock.save(any(Sensor.class))).thenReturn(new Sensor());

        assertDoesNotThrow(()-> sensorServiceMock.registerSensor(sensorNameValid));

    }

    @Test
    public void SensorService_RegisterSensor_ThrowsException() {

        String sensorName = "ExistingSensor";
        when(sensorRepositoryMock.findByName(sensorName)).thenReturn(Optional.of(new Sensor()));

        assertThrows(IllegalArgumentException.class, () -> sensorServiceMock.registerSensor(sensorName));
    }

    @Test
    public void registerSensor_ThrowsException_WhenSensorNameIsInvalid() {

        String sensorName = "";
        assertThrows(IllegalArgumentException.class, () -> sensorServiceMock.registerSensor(sensorName));

    }

}