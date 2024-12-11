package com.example.demo.repositories;

import com.example.demo.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor , Long> {
    Optional<Sensor> findByName(String name);
}
