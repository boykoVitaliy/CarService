package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.dto.CarDto.CarDto;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.service.CarService;

import javax.validation.Valid;
import java.util.List;

import static ua.com.carservice.constants.ResourceMapping.*;

@RestController
public class CarController {

    private final CarService carService;
private final CarRepository carRepository;

    @Autowired
    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    @GetMapping(CAR)
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @GetMapping(CAR + COLOR)
    public List<CarDto> findByColor(Color color) {
        return carService.findByColor(color);
    }

    @GetMapping(CAR + YEAR)
    @ResponseBody
    public List<CarDto> findByYear(@RequestParam Integer year) {
        return carService.findByYear(year);
    }


    @PostMapping(CAR + "/car/{Id}")
    public Car save(Long userId,CarSaveDto carSaveDto) {
        return carService.save(userId, carSaveDto);
    }

    @PostMapping(CAR + "/{carId}")
    public Car update(@PathVariable(value = "carId") Long carId, CarDto carDto) {
        return carService.update(carId,carDto);
    }

    @GetMapping(CAR + "/{deleteId}")
    public void deleteById(Long id) {
        carService.deleteById(id);
    }
    
}