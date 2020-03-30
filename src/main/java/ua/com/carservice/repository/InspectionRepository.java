package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.Inspection;
import ua.com.carservice.entity.User;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {
}
