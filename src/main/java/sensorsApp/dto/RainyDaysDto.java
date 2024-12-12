package sensorsApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response DTO for getRainyDaysCount method
 * @param count of rainy days
 */
@Schema(description = "Rainy days count DTO")
public record RainyDaysDto(
        @Schema(description = "Value long type", example = "234")
        long count) {
}