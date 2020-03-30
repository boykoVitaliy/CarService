package ua.com.carservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.service.GoodsService;

import java.util.List;

import static ua.com.carservice.constants.ResourceMapping.GOODS;

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


    @GetMapping("/goods/price")
    @ResponseBody
    public List<Goods> findGoodsByPrice(@RequestParam(required = false) Double price) {
        return goodsService.findGoodsByPrice(price);
    }


    @GetMapping("/goods/category")
    @ResponseBody
    public List<Goods> findGoodsByCategory(@RequestParam(required = false) String category) {
        return goodsService.findGoodsByCategory(category);
    }

    @GetMapping("/goods/firm")
    @ResponseBody
    public List<Goods> findGoodsByFirm(@RequestParam(required = false) String firm) {
        return goodsService.findGoodsByFirm(firm);
    }
}
