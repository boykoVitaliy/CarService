package ua.com.carservice.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.com.carservice.entity.Inspection;
import ua.com.carservice.repository.InspectionRepository;
import ua.com.carservice.service.InspectionService;

import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository inspectionRepository;

    public InspectionServiceImpl(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    @Override
    public List<Inspection> findAll() {
        return inspectionRepository.findAll();
    }

    @Override
    public List<Inspection> findByPrice(Double price) {
        return inspectionRepository.findByPrice(price);
    }

    @Override
    public List<Inspection> findBySupport(String support) {
        return inspectionRepository.findBySupport(support);
    }

    @Override
    public List<Inspection> findByPriceIsGreaterThan(Double price) {
        return inspectionRepository.findByPriceIsGreaterThan(price);
    }

    @Override
    public Inspection save(Inspection inspect) {
        return inspectionRepository.save(inspect);
    }

    @Override
    public void deleteById(Long id) {
        inspectionRepository.deleteById(id);
    }


}
