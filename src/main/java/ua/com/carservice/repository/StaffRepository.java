package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.Staff;
import ua.com.carservice.entity.User;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
