package ua.com.carservice.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.com.carservice.entity.Staff;
import ua.com.carservice.entity.enums.Position;
import ua.com.carservice.repository.StaffRepository;
import ua.com.carservice.service.StaffService;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public List<Staff> findByFirstName(String firstName) {
        return staffRepository.findByFirstName(firstName);
    }

    @Override
    public List<Staff> findStaffByFirstNameAndLastName(String firstName, String lastName) {
        return staffRepository.findStaffByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Staff> findByPosition(Position position) {
        return staffRepository.findByPosition(position);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }
}
