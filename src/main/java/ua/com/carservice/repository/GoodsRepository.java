package ua.com.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.carservice.entity.Goods;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

    List<Goods> findGoodsByPrice(Double price);
    List<Goods> findGoodsByCategory(String category);
    List<Goods> findGoodsByFirm(String firm);
}
