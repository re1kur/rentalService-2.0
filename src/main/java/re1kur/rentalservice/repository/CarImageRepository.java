package re1kur.rentalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re1kur.rentalservice.entity.CarImage;

import java.util.Collection;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
    Collection<CarImage> findAllByCarId(int id);
}
