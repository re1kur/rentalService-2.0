package re1kur.rentalservice.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import re1kur.rentalservice.dto.car.details.CarDetailsWriteDto;
import re1kur.rentalservice.dto.car.images.CarImageWriteDto;

@Builder
@Getter
@Setter
public class CarWriteDto {
    @NotNull
    private int makeId;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 64)
    private String model;

    @Positive
    private int year;

    @Size(min = 6, max = 6)
    @NotNull
    @NotBlank
    private String licensePlate;

    private CarDetailsWriteDto details;

    private CarImageWriteDto image;
}
