package ua.com.carservice.service;

import ua.com.carservice.dto.StaffDto.StaffSaveDto;
import ua.com.carservice.entity.Staff;
import ua.com.carservice.entity.enums.Position;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    List<Staff> findAll();

    List<Staff> findByFirstName(String firstName);

    List<Staff> findStaffByFirstNameAndLastName(String firstName, String lastName);

    Optional<Staff> findById(Long id);

    List<Staff> findByPosition(Position position);

    Staff save(StaffSaveDto staffSaveDto);

    void deleteById(Long id);
}
