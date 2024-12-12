package sensorsApp.mappres;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sensorsApp.domain.Sensor;
import sensorsApp.dto.SensorDto;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * Mapper for sensor
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface SensorMapper {

    @Mapping(target = "sensorName", source = "sensorDto.name")
    Sensor toEntity(SensorDto sensorDto);
}