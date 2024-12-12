package sensorsApp.mappres;

import org.mapstruct.*;
import sensorsApp.domain.Measurement;
import sensorsApp.dto.MeasurementDto;

import java.util.List;

/**
 * Mapper for measurement
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeasurementMapper {

    Measurement toEntity(MeasurementDto measurementDto);

    MeasurementDto toDto(Measurement measurement);

    List<MeasurementDto> toMeasurementsList(List<Measurement> measurements);
}