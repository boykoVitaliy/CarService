package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCars(Car car);
//    List<User> findByModelCars(Car model);
    List<User> findByNumber (Long number);
    List<User> findByEmail(String email);

}
