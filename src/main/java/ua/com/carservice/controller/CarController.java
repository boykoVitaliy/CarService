package ua.com.carservice.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.dto.CarDto.CarDto;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.service.CarService;

import java.util.List;

import static ua.com.carservice.constants.ResourceMapping.*;


@RestController
@Log4j2
public class CarController {
    private static final Logger logger = LogManager.getLogger(CarController.class);
    private final CarService carService;
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

//    public CarController(){}
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
    public List<CarDto> findByYear(@RequestParam Integer year)  {

        return carService.findByYear(year);
    }


    @PostMapping(CAR + "/car/{Id}")
    public Car save(Long userId, CarSaveDto carSaveDto)  {
        return carService.save(userId, carSaveDto);
    }

    @PostMapping(CAR + "/{carId}")
    public Car update(@PathVariable(value = "carId") Long carId, CarDto carDto) {
        return carService.update(carId, carDto);
    }

    public static Logger getLog() {
        log.debug("Welcome to debug");
        return log;
    }

    @GetMapping(CAR + "/{delete_Id}")
    public void deleteById(Long id) {

            if(logger.isDebugEnabled()){
                log.debug("welcome to debug");
            }
            try{
            carService.deleteById(id);
    }catch (Exception e){
                log.error("Welcome error");
            }
    }

    @GetMapping(CAR + "/by_user")
    public List<Car> findCarByUserId(Long userId) {
        return carService.findCarByUserId(userId);
    }
}