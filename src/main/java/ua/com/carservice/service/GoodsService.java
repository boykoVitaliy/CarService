package ua.com.carservice.service;

import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.entity.enums.Color;

import java.util.List;

public interface GoodsService {


    List<Goods>findAll();
    List<Goods> findGoodsByPrice(Double price);
    List<Goods> findGoodsByCategory(String category);
    List<Goods> findGoodsByFirm(String firm);
}
