package ua.com.carservice.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByCars(Car car) {
        return userRepository.findByCars(car);
    }

    @Override
    public List<User> findByNumber(Long number) {
        return userRepository.findByNumber(number);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
