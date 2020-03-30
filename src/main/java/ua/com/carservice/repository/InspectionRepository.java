package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.Inspection;
import ua.com.carservice.entity.User;

import java.util.List;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {

    List<Inspection> findByPrice(Double price);
    List<Inspection> findBySupport(String support);
    List<Inspection> findByPriceIsGreaterThan(Double price);
}
