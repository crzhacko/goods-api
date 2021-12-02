package com.alice.goods.api.repository;


import com.alice.goods.api.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GoodsRepository extends JpaRepository<Goods, Long> , GoodsRepositoryCustom{

}
