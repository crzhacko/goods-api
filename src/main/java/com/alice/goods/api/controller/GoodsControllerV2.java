package com.alice.goods.api.controller;

import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.service.GoodsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor
@RestController
@RequestMapping("v2/goods")
public class GoodsControllerV2 {

    private final GoodsService service;

    /**
     * https://stackoverflow.com/questions/35404329/swagger-documentation-for-spring-pageable-interface
     * @param pageable
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping
    public ResponseEntity<Page<GoodsDto>> findAll(@ApiIgnore Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

}
