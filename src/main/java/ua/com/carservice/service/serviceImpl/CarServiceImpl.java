package ua.com.carservice.service.serviceImpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.constants.Errors;
import ua.com.carservice.constants.logMessage;
import ua.com.carservice.dto.CarDto.CarDto;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.exception.EmptyFieldException;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.CarService;

import java.util.List;



@Slf4j
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

        log.info(logMessage.FIND_BY_COLOR+color);
        return modelMapper.map(carRepository.findByColor(color), new TypeToken<List<CarDto>>() {
        }.getType());
    }

    @Override
    public List<CarDto> findByYear(Integer year) {

        log.info(logMessage.FIND_BY_YEAR+year);

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

        log.info(logMessage.FIND_CAR_BY_USER_ID+userId);

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