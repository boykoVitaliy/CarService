package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByColor(Color color);

    List<Car> findAllByYearAndFirm(String firm, Integer age);

    List<Car> findByYear(Integer year);


}
