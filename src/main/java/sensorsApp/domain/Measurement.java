package sensorsApp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Measurement entity class
 */
@Getter
@Setter
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "value", nullable = false)
    private float value;

    @Column(name = "raining", nullable = false)
    private boolean raining;

    @Column(name = "sensor_name", nullable = false)
    private String sensorName;

}