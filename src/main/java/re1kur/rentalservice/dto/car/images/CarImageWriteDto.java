package re1kur.rentalservice.dto.car.images;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarImageWriteDto {
    private String url;

    private String bucket;

    private MultipartFile image;
}
