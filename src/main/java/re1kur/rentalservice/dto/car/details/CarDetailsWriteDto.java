package re1kur.rentalservice.dto.car.details;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import re1kur.rentalservice.entity.Car;

@Data
@Builder
public class CarDetailsWriteDto {
    private Car car;

    @NotBlank
    @Size(min = 2, max = 20)
    private String color;

    @PositiveOrZero
    private int mileage;

    @NotBlank
    @Size(min = 2, max = 20)
    private String fuelType;

    @NotBlank
    @Size(min = 2, max = 30)
    private String transmission;
}
