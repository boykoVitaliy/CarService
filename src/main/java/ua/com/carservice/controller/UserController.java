package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.dto.GoodsDto.GoodsAddUserDto;
import ua.com.carservice.dto.UserDto.UserSaveDto;
import ua.com.carservice.dto.UserDto.UserUpdateDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.entity.User;
import ua.com.carservice.service.UserService;

import static ua.com.carservice.constants.ResourceMapping.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(USER)
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(USER + USER_CARS)
    @ResponseBody
    public List<User> findByCars(@RequestParam(required = false) Car car) {
        return userService.findByCars(car);
    }

    @GetMapping(USER + USER_NUMBER)
    @ResponseBody
    public List<User> findByNumber(@RequestParam(required = false) Long number) {
        return userService.findByNumber(number);
    }

    @GetMapping(USER + USER_EMAIL)
    @ResponseBody
    public List<User> findByEmail(@RequestParam(required = false) String email) {
        return userService.findByEmail(email);
    }

    @PostMapping(USER + "/{userId}")
    public User save(UserSaveDto userDto) {
        return userService.save(userDto);
    }

    @PostMapping(USER+"/{updateId}")
    public User update(Long userId, UserUpdateDto userUpdateDto) {
        return userService.update(userId, userUpdateDto);
    }

    @GetMapping(USER + "/{deleteId}")
    public void deleteById(Long id) {
        userService.deleteById(id);
    }


}