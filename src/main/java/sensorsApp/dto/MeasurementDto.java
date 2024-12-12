package sensorsApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link sensorsApp.domain.Measurement}
 */
@Schema(description = "Measurement DTO")
public record MeasurementDto(
        @Schema(description = "Value float type", example = "23.5")
        @NotNull(message = "Sensor float value can't be Null") float value,
        @Schema(description = "boolean type", example = "false")
        @NotNull(message = "It's either raining or it's not raining") boolean raining,
        @Schema(description = "Sensor's name", example = "foo-bar")
        @NotBlank(message = "Sensor name can't be Null or Empty") String name) {
}