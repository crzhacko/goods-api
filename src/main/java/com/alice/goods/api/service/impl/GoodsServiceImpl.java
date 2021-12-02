package com.alice.goods.api.service.impl;

import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.entity.Goods;
import com.alice.goods.api.exception.FailedToCreateGoodsException;
import com.alice.goods.api.exception.GoodsNotFoundException;
import com.alice.goods.api.mapper.GoodsMapper;
import com.alice.goods.api.repository.GoodsRepository;
import com.alice.goods.api.repository.TestGoodsRepository;
import com.alice.goods.api.service.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository repository;
    private final GoodsMapper mapper;

    /**
     * 상품 등록
     * @param goods
     */
    @Override
    public void add(GoodsDto goods) {
        log.info("Create {}", goods);

        Goods created = repository.save(mapper.toEntity(goods));
        Optional.ofNullable(created.getGoodsNo())
                .orElseThrow(() -> new FailedToCreateGoodsException());
    }

    /**
     * 상품 수정
     * @param goods
     */
    @Override
    public void edit(GoodsDto goods) {
        log.info("Update {}", goods);

        Goods found = repository.findById(goods.getGoodsNo())
                        .orElseThrow(() -> new GoodsNotFoundException(goods.getGoodsNo()));

        mapper.update(goods, found);
    }

    /**
     * 특정 상품 삭제
     * @param goodsNo
     */
    @Override
    public void remove(Long goodsNo) {
        log.info("Remove Goods by {}", goodsNo);
        repository.deleteById(goodsNo);
    }

    /**
     * 특정 상품 조회
     * @param goodsNo
     */
    @Override
    public GoodsDto findById(Long goodsNo) {
        log.info("Retrieve Goods by {}", goodsNo);

        return repository.findById(goodsNo)
                .map(mapper::toDto)
                .orElseThrow(() -> new GoodsNotFoundException(goodsNo));
    }

    /**
     * 전체 상품 조회
     */
    @Override
    public List<GoodsDto> findAll() {
        log.info("retrieve all goods");
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

//        return mapper.toDtos(goodsRepositoryImpl.selectGetGoodsList());
    }

    @Override
    public Page<GoodsDto> findAll(Pageable pageable) {
        Page<Goods> result = repository.findAll(pageable);
        return new PageImpl<>(
                result.stream()
                        .map(mapper::toDto)
                        .collect(Collectors.toList()),
                pageable,
                result.getTotalElements());
    }
}
