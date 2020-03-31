package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.carservice.entity.Staff;
import ua.com.carservice.entity.enums.Position;
import ua.com.carservice.service.StaffService;

import java.util.List;
import java.util.Optional;

import static ua.com.carservice.constants.ResourceMapping.*;

@RestController
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    @GetMapping(STAFF)
    @ResponseBody
    public List<Staff> findAll() {
        return staffService.findAll();
    }

    @GetMapping(STAFF+STAFF_NAME)
    @ResponseBody
    public List<Staff> findByFirstName(@RequestParam(required = false)String firstName) {
        return staffService.findByFirstName(firstName);
    }

    @GetMapping(STAFF+STAFF_ALL_NAME)
    @ResponseBody
    public List<Staff> findStaffByFirstNameAndLastName(String firstName, String lastName) {
        return staffService.findStaffByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping(STAFF+STAFF_ID)
    @ResponseBody
    public Optional<Staff> findById(@RequestParam(required = false)Long id) {
        return Optional.empty();
    }

    @GetMapping(STAFF+POSITION)
    @ResponseBody
    public List<Staff> findByPosition(@RequestParam(required = false) Position position) {
        return staffService.findByPosition(position);
    }
}
