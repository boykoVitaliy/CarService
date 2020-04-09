package ua.com.carservice.service;

import ua.com.carservice.entity.Inspection;

import java.util.List;

public interface InspectionService {

    List<Inspection> findAll();
    List<Inspection> findByPrice(Double price);
    List<Inspection> findBySupport(String support);
    List<Inspection> findByPriceIsGreaterThan(Double price);

    Inspection save(Inspection inspect);
    void deleteById(Long id);
}
