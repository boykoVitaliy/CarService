package ua.com.carservice.service;

import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findByCars(Car car);
    List<User> findByNumber (Long number);
    List<User> findByEmail(String email);

}
