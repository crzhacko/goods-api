package com.alice.goods.api.mapper;

import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.entity.Goods;
import com.alice.goods.api.entity.Review;
import org.mapstruct.*;

import java.util.List;

/**
 * ref: https://kdrozd.pl/how-to-perform-a-partial-update-patch-with-explicit-null/
 */
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GoodsMapper {

    @Mappings({
        @Mapping(source = "review.reviewCnt", target = "reviewCnt"),
        @Mapping(source = "review.reviewAvg", target = "reviewAvg")
    })
    GoodsDto toDto(Goods goods);

    Goods toEntity(GoodsDto dto);

    List<GoodsDto> toDtos(List<Goods> goodsList);

    @InheritConfiguration
    @Mapping(target = "goodsNm", ignore = true)
    void update(GoodsDto update, @MappingTarget Goods destination);

}
