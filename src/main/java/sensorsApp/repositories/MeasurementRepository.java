package sensorsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sensorsApp.domain.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    /**
     * Find the number of rainy days
     * @return long value
     */
    long countByRainingTrue();


}