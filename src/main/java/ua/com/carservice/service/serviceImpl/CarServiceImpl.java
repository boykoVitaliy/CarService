package ua.com.carservice.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.dto.CarDto.CarDto;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> findAll() {
        return modelMapper.map(carRepository.findAll(),
                new TypeToken<List<CarDto>>() {
                }.getType());
    }

    @Override
    public List<CarDto> findByColor(Color color) {
        return modelMapper.map(carRepository.findByColor(color), new TypeToken<List<CarDto>>() {
        }.getType());
    }

    @Override
    public List<CarDto> findByYear(Integer year) {

        return modelMapper.map(carRepository.findByYear(year), new TypeToken<List<CarDto>>() {
        }.getType());
    }


    @Override
    public Car save(Long userId, CarSaveDto carSaveDto) {
        Car car = modelMapper.map(carSaveDto, Car.class);
        return userRepository.findById(userId).map(user -> {
            car.setUser(user);
            return carRepository.save(car);
        }).orElseThrow(() -> new NotFoundException("NOT_FOUND_THIS_ID--" + userId));
    }

    @Override
    public List<Car> findCarByUserId(Long userId) {
        return modelMapper.map(carRepository.findCarByUserId(userId), new TypeToken<List<CarDto>>() {
        }.getType());
    }


    @Override
    public Car update(Long carId, CarDto carDto) {
        return carRepository.findById(carId)
                .map(car -> {
                    car.setFirm(carDto.getFirm());
                    car.setColor(carDto.getColor());
                    car.setModel(carDto.getModel());
                    car.setYear(carDto.getYear());
                    return carRepository.save(car);
                }).orElseThrow(() -> new NotFoundException("NOT_FOUND_THIS_ID--" + carId));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}