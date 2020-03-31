package ua.com.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
}
