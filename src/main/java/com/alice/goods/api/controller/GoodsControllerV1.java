package com.alice.goods.api.controller;

import com.alice.goods.api.dto.AliceResponse;
import com.alice.goods.api.service.GoodsService;
import com.alice.goods.api.dto.GoodsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/goods")
public class GoodsControllerV1 {

    private final GoodsService service;

    @PostMapping
    public ResponseEntity<AliceResponse> create(@Valid @RequestBody GoodsDto goods) {
        service.add(goods);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AliceResponse.of(HttpStatus.CREATED.value(), "Goods created."));
    }

    @PutMapping
    public ResponseEntity<AliceResponse> update(@RequestBody GoodsDto goods) {
        service.edit(goods);
        return ResponseEntity.ok(AliceResponse.of(HttpStatus.OK.value(), "Goods updated."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AliceResponse> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.ok(AliceResponse.of(HttpStatus.OK.value(), "Goods[goodsNo=" + id + "] deleted."));
    }

    @GetMapping
    public ResponseEntity<List<GoodsDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<GoodsDto> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
