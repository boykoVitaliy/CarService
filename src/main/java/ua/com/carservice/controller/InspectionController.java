package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.dto.InspectionDto.InspectionDto;
import ua.com.carservice.dto.InspectionDto.InspectionUpdateDto;
import ua.com.carservice.entity.Inspection;
import ua.com.carservice.service.InspectionService;

import java.util.List;

import static ua.com.carservice.constants.ResourceMapping.*;

@RestController
public class InspectionController {

    private final InspectionService inspectionService;


    @Autowired
    public InspectionController(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @GetMapping(INSPECTION)
    @ResponseBody
    public List<Inspection> findAll() {

        return inspectionService.findAll();
    }

    @GetMapping(INSPECTION+INSPECTION_PRICE)
    @ResponseBody
    public List<Inspection> findByPrice(@RequestParam(required = false) Double price) {
        return inspectionService.findByPrice(price);
    }

    @GetMapping(INSPECTION+SUPPORT)
    @ResponseBody
    public List<Inspection> findBySupport(@RequestParam(required = false) String support) {
        return inspectionService.findBySupport(support);
    }

    @GetMapping(INSPECTION+BIGGER_PRICE)
    @ResponseBody
    public List<Inspection> findByPriceIsGreaterThan(@RequestParam(required = false) Double price) {
        return inspectionService.findByPriceIsGreaterThan(price);
    }


    @PostMapping(INSPECTION+"/{inspectId}")
    public Inspection save(InspectionDto inspect) {
        return inspectionService.save(inspect);
    }

    @GetMapping(INSPECTION+"/{deleteId}")
    public void deleteById(Long id) {
        inspectionService.deleteById(id);
    }

    @PostMapping(INSPECTION+"/{updateInspectionId}")
    public Inspection update(Long inspectionId , InspectionUpdateDto inspectionUpdateDto){
        return inspectionService.update(inspectionId,inspectionUpdateDto);
    }
}
