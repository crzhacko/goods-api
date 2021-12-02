package com.alice.goods.api.service;

import com.alice.goods.api.dto.GoodsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {

    void add(GoodsDto goods);
    void edit(GoodsDto goods);
    void remove(Long goodsNo);
    GoodsDto findById(Long goodsNo);
    List<GoodsDto> findAll();
    Page<GoodsDto> findAll(Pageable pageable);

}
