package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.service.CarService;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
//
//    @GetMapping(CAR+YEAR_FIRM)
//    @ResponseBody
//    public List<Car> findAllByYearAndFirm( @RequestParam(value = "firm",required = false) String firm,  @RequestParam(value = "age",required = false)Integer age) {
//        return carService.findAllByYearAndFirm(firm, age);
//    }


    @GetMapping(YEAR_FIRM)
    @ResponseBody

    public Set<Map.Entry<String, Integer>> findAllByYearAndFirm(@RequestParam Map<String,Integer> carService ) {
        return carService.entrySet();
    }

    @GetMapping(CAR+YEAR)
    @ResponseBody
    public List<Car> findByYear(@RequestParam(required = false  ) Integer year) {
        return carService.findByYear(year);
    }

}
