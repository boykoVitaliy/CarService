package ua.com.carservice.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.dto.CarDto.CarDto;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.exception.EmptyFieldException;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.CarService;
import ua.com.carservice.constants.Errors;


import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {

    private static Logger logger = LogManager.getLogger(CarServiceImpl.class);

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
//      log.info("Test log");


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

        List<Car> carYear = carRepository.findByYear(year);

        if (carYear.isEmpty()){
            throw new NotFoundException(Errors.NOT_FOUND_YEAR + year);
        }

        return modelMapper.map(carRepository.findByYear(year), new TypeToken<List<CarDto>>() {
        }.getType());
    }


    @Override
    public Car save(Long userId, CarSaveDto carSaveDto) {
        Car car = modelMapper.map(carSaveDto, Car.class);
        return userRepository.findById(userId).map(user -> {
            car.setUser(user);
            return carRepository.save(car);
        }).orElseThrow(() -> new NotFoundException("Not_Found_Id " + userId));
    }

    @Override
    public List<Car> findCarByUserId(Long userId) {
        List<Car> carByUser = carRepository.findCarByUserId(userId);

        if (userId==null){
            throw new EmptyFieldException(Errors.FIELD_USERID_IS_EMPTY);
        }
        else if (carByUser.isEmpty()){
            throw new NotFoundException(Errors.NOT_FOUND_INFO);

        }

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