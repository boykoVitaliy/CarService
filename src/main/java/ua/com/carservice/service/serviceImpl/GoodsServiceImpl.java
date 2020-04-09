package ua.com.carservice.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.entity.enums.Color;
import ua.com.carservice.repository.GoodsRepository;
import ua.com.carservice.service.GoodsService;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }


    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> findGoodsByPrice(Double price) {
        return goodsRepository.findGoodsByPrice(price);
    }

    @Override
    public List<Goods> findGoodsByCategory(String category) {
        return goodsRepository.findGoodsByCategory(category);
    }

    @Override
    public List<Goods> findGoodsByFirm(String firm) {
        return goodsRepository.findGoodsByFirm(firm);
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void deleteById(Long id) {
        goodsRepository.deleteById(id);

    }


}
