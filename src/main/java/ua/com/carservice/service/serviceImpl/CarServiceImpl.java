package ua.com.carservice.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByColor(Color color) {
        return carRepository.findByColor(color);
    }

    @Override
    public List<Car> findAllByYearAndFirm(String firm, int age) {
        return carRepository.findAllByYearAndFirm(firm, age);
    }

    @Override
    public List<Car> findByYear(Integer year) {
        return carRepository.findByYear(year);
    }
}
