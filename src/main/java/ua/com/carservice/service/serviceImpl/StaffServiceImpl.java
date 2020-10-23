package ua.com.carservice.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.com.carservice.constants.Errors;
import ua.com.carservice.entity.Inspection;
import ua.com.carservice.entity.Staff;
import ua.com.carservice.entity.enums.Position;
import ua.com.carservice.exception.EmptyFieldException;
import ua.com.carservice.exception.NotFoundException;
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

        List<Staff> findByFirstName = staffRepository.findByFirstName(firstName);

        if(findByFirstName.isEmpty()){

            throw new NotFoundException(Errors.STAFF_NOT_FOUND+firstName);
        }

        return staffRepository.findByFirstName(firstName);
    }

    @Override
    public List<Staff> findStaffByFirstNameAndLastName(String firstName, String lastName) {

        List<Staff> findByFirstNameAndLastName = staffRepository.findStaffByFirstNameAndLastName(firstName,lastName);

        if(findByFirstNameAndLastName.isEmpty()){

            throw new NotFoundException(Errors.STAFF_NOT_FOUND+firstName+lastName);
        }


        return staffRepository.findStaffByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<Staff> findById(Long id) {

        return (Optional<Staff>) Optional.empty().orElseThrow(()->new NotFoundException("NOT_FOUND_THIS_ID"+id));
    }

    @Override
    public List<Staff> findByPosition(Position position) {
        List<Staff> findByPosition = staffRepository.findByPosition(position);

        if(position==null){

            throw new EmptyFieldException(Errors.FIELD_IS_EMPTY);
        }


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
