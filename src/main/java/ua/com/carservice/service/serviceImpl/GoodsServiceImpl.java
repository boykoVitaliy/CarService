package ua.com.carservice.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.dto.GoodsDto.GoodsDto;
import ua.com.carservice.dto.GoodsDto.GoodsSaveDto;
import ua.com.carservice.dto.GoodsDto.GoodsUpdateDto;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.GoodsRepository;
import ua.com.carservice.service.GoodsService;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository, ModelMapper modelMapper) {
        this.goodsRepository = goodsRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Goods> findAll() {

        return modelMapper.map(goodsRepository.findAll(), new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public List<Goods> findGoodsByPrice(Double price) {
        return modelMapper.map(goodsRepository.findGoodsByPrice(price),new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public List<Goods> findGoodsByCategory(String category) {
        return modelMapper.map(goodsRepository.findGoodsByCategory(category),new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public List<Goods> findGoodsByFirm(String firm) {
        return modelMapper.map(goodsRepository.findGoodsByFirm(firm),new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public Goods save(GoodsSaveDto goodsDto) {
        return goodsRepository.save(modelMapper.map(goodsDto, Goods.class));
    }

    @Override
    public void deleteById(Long id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goods update(Long goodsId, GoodsUpdateDto goodsUpdate) {
        return goodsRepository.findById(goodsId).map(goods -> {
            goods.setPrice(goodsUpdate.getPrice());
            return goodsRepository.save(goods);
        }).orElseThrow(()->new NotFoundException("NOT_FOUND_THIS_ID "+goodsId));
    }


}
