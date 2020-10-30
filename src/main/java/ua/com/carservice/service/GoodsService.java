package ua.com.carservice.service;

import ua.com.carservice.dto.GoodsDto.GoodsAddUserDto;
import ua.com.carservice.dto.GoodsDto.GoodsDto;
import ua.com.carservice.dto.GoodsDto.GoodsSaveDto;
import ua.com.carservice.dto.GoodsDto.GoodsUpdateDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.entity.enums.Color;

import java.util.List;

public interface GoodsService {


    List<GoodsDto> findAll();

    List<GoodsDto> findGoodsByPrice(Double price);

    List<GoodsDto> findGoodsByCategory(String category);

    List<GoodsDto> findGoodsByFirm(String firm);

    Goods save(GoodsSaveDto goodsDto);

    void deleteById (Long id);

    Goods update(Long goodsId , GoodsUpdateDto goodsUpdate);

    Goods updateGoods(Long userId, GoodsAddUserDto goodsAddDto);
}
