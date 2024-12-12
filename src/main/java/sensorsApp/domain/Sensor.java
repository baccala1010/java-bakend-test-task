package sensorsApp.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Sensor entity class
 */
@Getter
@Setter
@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "sensor_name", nullable = false, unique = true)
    public String sensorName;
}