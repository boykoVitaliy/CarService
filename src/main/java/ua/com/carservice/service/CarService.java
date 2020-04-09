package ua.com.carservice.service;

import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    List<Car> findByColor(Color color);

    List<Car> findByYear(Integer year);

    Car save(Car car);

    void deleteById(Long id);

}
