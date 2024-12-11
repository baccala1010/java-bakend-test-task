package com.example.demo.controllers;

import com.example.demo.models.Sensor;
import com.example.demo.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<String> registerSensor(@RequestBody @Validated Sensor sensor) {
        sensorService.registerSensor(sensor.getName());
        return new ResponseEntity<>("Sensor registered successfully!", HttpStatus.CREATED);
    }

}
