package ua.com.carservice.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.constants.Errors;
import ua.com.carservice.dto.GoodsDto.GoodsAddUserDto;
import ua.com.carservice.dto.GoodsDto.GoodsDto;
import ua.com.carservice.dto.GoodsDto.GoodsSaveDto;
import ua.com.carservice.dto.GoodsDto.GoodsUpdateDto;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.exception.EmptyFieldException;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.GoodsRepository;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.GoodsService;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.goodsRepository = goodsRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<Goods> findAll() {

        return modelMapper.map(goodsRepository.findAll(), new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public List<Goods> findGoodsByPrice(Double price) {

        List<Goods> goodsByPrice = goodsRepository.findGoodsByPrice(price);

        if(price==null){
            throw new EmptyFieldException(Errors.FIELD_PRICE_IS_EMPTY);
        }
        else if(goodsByPrice.isEmpty()){
            throw new NotFoundException(Errors.NOT_FOUND_GOODS+price);
        }

        return modelMapper.map(goodsRepository.findGoodsByPrice(price),new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public List<Goods> findGoodsByCategory(String category) {

        List<Goods> goodsByCategory = goodsRepository.findGoodsByCategory(category);

        if(category==null){
            throw new EmptyFieldException(Errors.FIELD_CATEGORY_IS_EMPTY);
        }
else if(goodsByCategory.isEmpty()){
    throw new NotFoundException(Errors.NOT_FOUND_GOODS+category);
        }

        return modelMapper.map(goodsRepository.findGoodsByCategory(category),new TypeToken<List<GoodsDto>>(){}.getType());
    }

    @Override
    public List<Goods> findGoodsByFirm(String firm) {


        List<Goods> goodsByFirm = goodsRepository.findGoodsByFirm(firm);

        if(firm==null){
            throw new EmptyFieldException(Errors.FIELD_FIRM_IS_EMPTY);
        }
        else if(goodsByFirm.isEmpty()){
            throw new NotFoundException(Errors.NOT_FOUND_GOODS+firm);
        }

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

    @Override
    public Goods updateGoods(Long userId, GoodsAddUserDto goodsAddDto){
        Goods goods = modelMapper.map(goodsAddDto, Goods.class);
        return userRepository.findById(userId).map(user->{

            return goodsRepository.save(goods);
        }).orElseThrow(()->new NotFoundException("NOT_FOUND_THIS_ID--"+userId));
    }

}
