package com.example.demo.repositories;

import com.example.demo.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    long countByRainingTrue();
}
