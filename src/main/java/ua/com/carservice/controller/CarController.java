package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.service.CarService;

import java.util.List;
import java.util.Optional;

import static ua.com.carservice.constants.ResourceMapping.*;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(CAR)
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping(CAR + COLOR)
    public List<Car> findByColor(Color color) {
        return carService.findByColor(color);
    }

//    @GetMapping(CAR+YEAR_FIRM)
//    @ResponseBody
//    public List<Car> findAllByYearAndFirm( @RequestParam(value = "firm",required = false) String firm,  @RequestParam(value = "age",required = false)Integer age) {
//        return carService.findAllByYearAndFirm(firm, age);
//    }


//    @GetMapping(CAR + YEAR_FIRM)
//    @ResponseBody
//
//    public Set<Map.Entry<String, Integer>> findAllByYearAndFirm(@RequestParam Map<String, Integer> carService) {
//        return carService.entrySet();
//    }

    @GetMapping(CAR + YEAR)
    @ResponseBody
    public List<Car> findByYear(@RequestParam(required = false) Integer year) {
        return carService.findByYear(year);
    }

    @PostMapping(CAR + "/{carId}")
    public Car save(Car car) {
        return carService.save(car);
    }

    @GetMapping(CAR + "/{deleteId}")
    public void deleteById(Long id) {
        carService.deleteById(id);
    }

    @GetMapping(CAR + "/car-update/{id}")
    public Optional<Car> findById(Long id) {
        return carService.findById(id);
    }
    @PostMapping(CAR+"/car-update")
    public Car updateCar(Car car){
        return carService.save(car);
    }
}