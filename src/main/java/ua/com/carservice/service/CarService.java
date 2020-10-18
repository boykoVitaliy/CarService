package ua.com.carservice.service;

import ua.com.carservice.dto.CarDto.CarDto;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;
import ua.com.carservice.entity.enums.Color;

import java.util.List;

public interface CarService {

    List<CarDto> findAll();

    List<CarDto> findByColor(Color color);

    List<CarDto> findByYear(Integer year);

    Car update (Long carId, CarDto carDto);

    void deleteById(Long id) ;

    Car save(Long userId,CarSaveDto carSaveDto);

    List<Car> findCarByUserId(Long userId);


}
