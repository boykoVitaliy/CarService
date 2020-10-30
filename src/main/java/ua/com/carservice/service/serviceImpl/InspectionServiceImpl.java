package ua.com.carservice.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import ua.com.carservice.constants.Errors;
import ua.com.carservice.dto.InspectionDto.InspectionDto;
import ua.com.carservice.dto.InspectionDto.InspectionUpdateDto;
import ua.com.carservice.entity.Inspection;
import ua.com.carservice.exception.EmptyFieldException;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.InspectionRepository;
import ua.com.carservice.service.InspectionService;

import javax.persistence.Id;
import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final ModelMapper modelMapper;
    private final InspectionRepository inspectionRepository;

    public InspectionServiceImpl(ModelMapper modelMapper, InspectionRepository inspectionRepository) {
        this.modelMapper = modelMapper;
        this.inspectionRepository = inspectionRepository;
    }

    @Override
    public List<InspectionDto> findAll() {

        return modelMapper.map(inspectionRepository.findAll(), new TypeToken<List<InspectionDto>>() {
        }.getType());
    }

    @Override
    public List<InspectionDto> findByPrice(Double price) {

        List<Inspection> findByPrice = inspectionRepository.findByPrice(price);

        if (findByPrice.isEmpty()) {

            throw new NotFoundException(Errors.NOT_FOUND_PRICE + price);
        } else if (price == null) {
            throw new EmptyFieldException(Errors.FIELD_IS_EMPTY);
        }

        return modelMapper.map(inspectionRepository.findByPrice(price), new TypeToken<List<InspectionDto>>() {
        }.getType());
    }

    @Override
    public List<InspectionDto> findBySupport(String support) {
        List<Inspection> findBySupport = inspectionRepository.findBySupport(support);

        if (support == null) {

            throw new EmptyFieldException(Errors.DID_NOT_SELECT_FIELD);

        }

        return modelMapper.map(inspectionRepository.findBySupport(support), new TypeToken<List<InspectionDto>>() {
        }.getType());
    }

    @Override
    public List<InspectionDto> findByPriceIsGreaterThan(Double price) {

        List<Inspection> findByPriceIsGreaterThan = inspectionRepository.findByPriceIsGreaterThan(price);

        if (price == null) {

            throw new EmptyFieldException(Errors.FIELD_IS_EMPTY + price);

        } else if (findByPriceIsGreaterThan.isEmpty()) {

            throw new NotFoundException(Errors.NOT_FOUND_PRICE+price);

        }

        return modelMapper.map(inspectionRepository.findByPriceIsGreaterThan(price), new TypeToken<List<InspectionDto>>() {
        }.getType());
    }

    @Override
    public Inspection save(InspectionDto inspect) {
        return inspectionRepository.save(modelMapper.map(inspect, Inspection.class));
    }

    @Override
    public void deleteById(Long id) {
        inspectionRepository.deleteById(id);
    }

    @Override
    public Inspection update(Long inspectionId, InspectionUpdateDto inspectionUpdateDto) {
        return inspectionRepository.findById(inspectionId).map(inspection -> {
            inspection.setId(inspectionUpdateDto.getId());
            inspection.setPrice(inspectionUpdateDto.getPrice());
            inspection.setSupport(inspectionUpdateDto.getSupport());
            return inspectionRepository.save(inspection);
        }).orElseThrow(() -> new NotFoundException("Not_Found_This_Id" + inspectionId));
    }


}
