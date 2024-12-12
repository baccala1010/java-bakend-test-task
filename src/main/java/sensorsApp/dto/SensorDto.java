package sensorsApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for {@link sensorsApp.domain.Sensor}
 */
@Schema(description = "Sensor DTO")
public record SensorDto(
        @Schema(description = "Sensor name String type", example = "Daleko")
        @NotBlank(message = "Sensor name can't be Null or Empty") String name) {
}