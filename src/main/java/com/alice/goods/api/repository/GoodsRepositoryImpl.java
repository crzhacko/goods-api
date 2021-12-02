package com.alice.goods.api.repository;


import com.alice.goods.api.entity.Goods;
import com.alice.goods.api.entity.QGoods;
import com.alice.goods.api.entity.QReview;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class GoodsRepositoryImpl extends QuerydslRepositorySupport implements GoodsRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    public GoodsRepositoryImpl() {
        super(Goods.class);
    }


    public Goods selectGetGoodsInfo(Long goodsNo){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QGoods goods = QGoods.goods;


        Goods result =

                query.from(goods)
                .select(Projections.constructor(Goods.class, goods.goodsNo, goods.goodsNm, goods.goodsCont, goods.price, goods.comId, goods.goodsImg, goods.regDm, goods.updDm))
                .where(goods.goodsNo.eq(goodsNo))
                .fetchOne();

        return result;
    }

    public List<Goods> selectGetGoodsList(){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QGoods goods = QGoods.goods;
        QReview review = QReview.review;

        List<Goods> result =
                query.from(goods)
                 .innerJoin(review).on(goods.goodsNo.eq(review.goodsNo))
                 .select(Projections.bean(Goods.class, goods.goodsNo, goods.goodsNm, goods.goodsCont, goods.comId, goods.regDm, goods.updDm,goods.goodsImg, goods.price,  review.reviewCnt ,review.reviewAvg))
                 .fetch();

        return result;
    }


}


