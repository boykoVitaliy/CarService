package ua.com.carservice.service;

import ua.com.carservice.dto.UserDto.UserDto;
import ua.com.carservice.dto.UserDto.UserSaveDto;
import ua.com.carservice.dto.UserDto.UserUpdateDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findByCars(Car car);

    List<User> findByNumber(Long number);

    List<User> findByEmail(String email);

    User save(UserSaveDto userDto);

    void deleteById(Long id);

    User update(Long userId, UserUpdateDto userUpdateDto);
}
