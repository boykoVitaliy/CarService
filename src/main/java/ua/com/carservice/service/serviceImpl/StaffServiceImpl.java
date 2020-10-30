package ua.com.carservice.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import ua.com.carservice.constants.Errors;
import ua.com.carservice.constants.logMessage;
import ua.com.carservice.dto.StaffDto.StaffDto;
import ua.com.carservice.dto.StaffDto.StaffSaveDto;
import ua.com.carservice.entity.Staff;
import ua.com.carservice.entity.enums.Position;
import ua.com.carservice.exception.EmptyFieldException;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.StaffRepository;
import ua.com.carservice.service.StaffService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;

    public StaffServiceImpl(StaffRepository staffRepository, ModelMapper modelMapper) {
        this.staffRepository = staffRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Staff> findAll() {
        return modelMapper.map(staffRepository.findAll(), new TypeToken<List<StaffDto>>() {
        }.getType());
    }

    @Override
    public List<Staff> findByFirstName(String firstName) {

log.info(logMessage.FIND_BY_FIRST_NAME+firstName);

        List<Staff> findByFirstName = staffRepository.findByFirstName(firstName);

        if (findByFirstName.isEmpty()) {

            throw new NotFoundException(Errors.STAFF_NOT_FOUND + firstName);
        }

        return modelMapper.map(staffRepository.findByFirstName(firstName), new TypeToken<List<StaffDto>>() {
        }.getType());
    }

    @Override
    public List<Staff> findStaffByFirstNameAndLastName(String firstName, String lastName) {

        log.info(logMessage.FIND_STAFF_BY_FIRST_AND_LAST_NAME+firstName+lastName);

        List<Staff> findByFirstNameAndLastName = staffRepository.findStaffByFirstNameAndLastName(firstName, lastName);

        if (findByFirstNameAndLastName.isEmpty()) {

            throw new NotFoundException(Errors.STAFF_NOT_FOUND + firstName + lastName);
        }


        return modelMapper.map(staffRepository.findStaffByFirstNameAndLastName(firstName, lastName), new TypeToken<List<StaffDto>>() {
        }.getType());
    }

    @Override
    public Optional<Staff> findById(Long id) {

        return (Optional<Staff>) Optional.empty().orElseThrow(() -> new NotFoundException("NOT_FOUND_THIS_ID" + id));
    }

    @Override
    public List<Staff> findByPosition(Position position) {

        log.info(logMessage.FIND_BY_POSITION);

        List<Staff> findByPosition = staffRepository.findByPosition(position);

        if (position == null) {

            throw new EmptyFieldException(Errors.FIELD_IS_EMPTY);
        }


        return modelMapper.map(staffRepository.findByPosition(position), new TypeToken<List<StaffDto>>() {
        }.getType());
    }

    @Override
    public Staff save(StaffSaveDto staffSaveDto) {
        return staffRepository.save(modelMapper.map(staffSaveDto, Staff.class));
    }

    @Override
    public void deleteById(Long id) {

        log.warn(logMessage.DELETE_BY_ID);

        staffRepository.deleteById(id);
    }
}
