package re1kur.rentalservice.dto.car.images;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageReadDto {
    private int id;
    private int carId;
    private String url;
    private LocalDateTime uploadedAt;
}
