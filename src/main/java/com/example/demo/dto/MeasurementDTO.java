package com.example.demo.dto;

import com.example.demo.models.Sensor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MeasurementDTO {
    public void setValue(Double value) {
        this.value = value;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    private Double value;

    public MeasurementDTO(Double value, Boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    private Boolean raining;
    private Sensor sensor;

    public Double getValue() {
        return value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
