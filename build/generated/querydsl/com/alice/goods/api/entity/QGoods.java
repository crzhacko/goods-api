package com.alice.goods.api.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoods is a Querydsl query type for Goods
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoods extends EntityPathBase<Goods> {

    private static final long serialVersionUID = -619733806L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoods goods = new QGoods("goods");

    public final StringPath comId = createString("comId");

    public final StringPath goodsCont = createString("goodsCont");

    public final StringPath goodsImg = createString("goodsImg");

    public final StringPath goodsNm = createString("goodsNm");

    public final NumberPath<Long> goodsNo = createNumber("goodsNo", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> regDm = createDateTime("regDm", java.time.LocalDateTime.class);

    public final QReview review;

    public final DateTimePath<java.time.LocalDateTime> updDm = createDateTime("updDm", java.time.LocalDateTime.class);

    public QGoods(String variable) {
        this(Goods.class, forVariable(variable), INITS);
    }

    public QGoods(Path<? extends Goods> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoods(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoods(PathMetadata metadata, PathInits inits) {
        this(Goods.class, metadata, inits);
    }

    public QGoods(Class<? extends Goods> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

