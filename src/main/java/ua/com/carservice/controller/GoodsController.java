package ua.com.carservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.dto.GoodsDto.GoodsAddUserDto;
import ua.com.carservice.dto.GoodsDto.GoodsSaveDto;
import ua.com.carservice.dto.GoodsDto.GoodsUpdateDto;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.service.GoodsService;

import java.util.List;

import static ua.com.carservice.constants.ResourceMapping.*;

@RestController
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping(GOODS)
    @ResponseBody
    public List<Goods> findAll() {
        return goodsService.findAll();
    }


    @GetMapping(GOODS + PRICE)
    @ResponseBody
    public List<Goods> findGoodsByPrice(@RequestParam(required = false) Double price) {
        return goodsService.findGoodsByPrice(price);
    }


    @GetMapping(GOODS + CATEGORY)
    @ResponseBody
    public List<Goods> findGoodsByCategory(@RequestParam(required = false) String category) {
        return goodsService.findGoodsByCategory(category);
    }

    @GetMapping(GOODS + GOODS_FIRM)
    @ResponseBody
    public List<Goods> findGoodsByFirm(@RequestParam(required = false) String firm) {
        return goodsService.findGoodsByFirm(firm);
    }

    @PostMapping(GOODS + "/{goodsId}")
    public Goods save(GoodsSaveDto goodsDto) {
        return goodsService.save(goodsDto);
    }

    @GetMapping(GOODS + "/{deleteId}")
    public void deleteById(Long id) {
        goodsService.deleteById(id);

    }

    @PostMapping(GOODS + "/{goodsUpdateId}")
    public Goods update(Long goodsId, GoodsUpdateDto goodsUpdate) {
        return goodsService.update(goodsId, goodsUpdate);
    }

    @PostMapping(GOODS+"/{addGoodsId}")
    public Goods updateGoods(Long userId, GoodsAddUserDto goodsAddDto){
        return goodsService.updateGoods(userId, goodsAddDto);
    }
}
