package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
