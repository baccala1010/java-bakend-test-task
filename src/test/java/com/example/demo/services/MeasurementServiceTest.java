package com.example.demo.services;

import com.example.demo.models.Measurement;
import com.example.demo.models.Sensor;
import com.example.demo.repositories.MeasurementRepository;
import com.example.demo.repositories.SensorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MeasurementServiceTest {

    @Mock
    private MeasurementRepository measurementRepositoryMock;

    @Mock
    private SensorRepository sensorRepositoryMock;

    @InjectMocks
    private MeasurementService measurementServiceMock;

    @Test
    public void MeasurementService_AddMeasurement_ReturnsSuccess(){

        String sensorName = "ValidSensorName";
        Sensor sensor = new Sensor();

        when(sensorRepositoryMock.findByName(sensorName)).thenReturn(Optional.of(sensor));
        when(measurementRepositoryMock.save(any(Measurement.class))).thenReturn(new Measurement());

        assertDoesNotThrow(() -> measurementServiceMock.addMeasurement(1.2 , false , sensorName));

    }

    @Test
    public void MeasurementService_GetAllMeasurements_ReturnsListOfMeasurements(){

        List<Measurement> measurementList = Arrays.asList(new Measurement() , new Measurement());
        when(measurementRepositoryMock.findAll()).thenReturn(measurementList);

        List<Measurement> measurements = measurementServiceMock.getAllMeasurements();

        assertThat(measurements).isNotNull();
        assertThat(measurements.size()).isEqualTo(2);
    }

    @Test
    public void MeasurementService_GetRainyDaysCount_ReturnsLong(){

        long rainyDaysMock = 1;
        when(measurementRepositoryMock.countByRainingTrue()).thenReturn(rainyDaysMock);

        long rainyDays = measurementServiceMock.getRainyDaysCount();

        assertThat(rainyDays).isEqualTo(rainyDaysMock);

    }

}