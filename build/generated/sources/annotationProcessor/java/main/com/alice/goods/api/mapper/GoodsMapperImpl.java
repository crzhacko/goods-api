package com.alice.goods.api.mapper;

import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.entity.Goods;
import com.alice.goods.api.entity.Review;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-01T19:28:59+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.7.1.jar, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class GoodsMapperImpl implements GoodsMapper {

    @Override
    public GoodsDto toDto(Goods goods) {
        if ( goods == null ) {
            return null;
        }

        GoodsDto goodsDto = new GoodsDto();

        goodsDto.setReviewCnt( goodsReviewReviewCnt( goods ) );
        goodsDto.setReviewAvg( goodsReviewReviewAvg( goods ) );
        goodsDto.setGoodsNo( goods.getGoodsNo() );
        goodsDto.setGoodsNm( goods.getGoodsNm() );
        goodsDto.setGoodsCont( goods.getGoodsCont() );
        goodsDto.setPrice( goods.getPrice() );
        goodsDto.setGoodsImg( goods.getGoodsImg() );
        goodsDto.setComId( goods.getComId() );
        goodsDto.setRegDm( goods.getRegDm() );
        goodsDto.setUpdDm( goods.getUpdDm() );

        return goodsDto;
    }

    @Override
    public Goods toEntity(GoodsDto dto) {
        if ( dto == null ) {
            return null;
        }

        Goods goods = new Goods();

        goods.setGoodsNo( dto.getGoodsNo() );
        goods.setGoodsNm( dto.getGoodsNm() );
        goods.setGoodsCont( dto.getGoodsCont() );
        goods.setComId( dto.getComId() );
        goods.setRegDm( dto.getRegDm() );
        goods.setUpdDm( dto.getUpdDm() );
        goods.setGoodsImg( dto.getGoodsImg() );
        goods.setPrice( dto.getPrice() );

        return goods;
    }

    @Override
    public List<GoodsDto> toDtos(List<Goods> goodsList) {
        if ( goodsList == null ) {
            return null;
        }

        List<GoodsDto> list = new ArrayList<GoodsDto>( goodsList.size() );
        for ( Goods goods : goodsList ) {
            list.add( toDto( goods ) );
        }

        return list;
    }

    @Override
    public void update(GoodsDto update, Goods destination) {
        if ( update == null ) {
            return;
        }

        if ( update.getGoodsNo() != null ) {
            destination.setGoodsNo( update.getGoodsNo() );
        }
        if ( update.getGoodsCont() != null ) {
            destination.setGoodsCont( update.getGoodsCont() );
        }
        if ( update.getComId() != null ) {
            destination.setComId( update.getComId() );
        }
        if ( update.getRegDm() != null ) {
            destination.setRegDm( update.getRegDm() );
        }
        if ( update.getUpdDm() != null ) {
            destination.setUpdDm( update.getUpdDm() );
        }
        if ( update.getGoodsImg() != null ) {
            destination.setGoodsImg( update.getGoodsImg() );
        }
        if ( update.getPrice() != null ) {
            destination.setPrice( update.getPrice() );
        }
    }

    private Integer goodsReviewReviewCnt(Goods goods) {
        if ( goods == null ) {
            return null;
        }
        Review review = goods.getReview();
        if ( review == null ) {
            return null;
        }
        Integer reviewCnt = review.getReviewCnt();
        if ( reviewCnt == null ) {
            return null;
        }
        return reviewCnt;
    }

    private Integer goodsReviewReviewAvg(Goods goods) {
        if ( goods == null ) {
            return null;
        }
        Review review = goods.getReview();
        if ( review == null ) {
            return null;
        }
        Integer reviewAvg = review.getReviewAvg();
        if ( reviewAvg == null ) {
            return null;
        }
        return reviewAvg;
    }
}
