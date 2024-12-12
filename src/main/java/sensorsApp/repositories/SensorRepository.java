package sensorsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sensorsApp.domain.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
}