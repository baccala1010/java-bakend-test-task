package com.example.demo.controllers;

import com.example.demo.dto.MeasurementDTO;
import com.example.demo.models.Measurement;
import com.example.demo.services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping("/add")
    public ResponseEntity<String> addMeasurement(@RequestBody MeasurementDTO measurementDTO) {
        measurementService.addMeasurement(
                measurementDTO.getValue(),
                measurementDTO.getRaining(),
                measurementDTO.getSensor().getName()
        );
        return ResponseEntity.ok("Measurement added successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        return ResponseEntity.ok(measurementService.getAllMeasurements());
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> getRainyDaysCount() {
        return ResponseEntity.ok(measurementService.getRainyDaysCount());
    }

}
